package com.example.kinogid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch
import java.util.UUID

class DetailListFragment: Fragment(), MovieSelectorDialogFragment.OnMoviesSelectedListener {
    lateinit var viewModel: MainViewModel
    private var adapter: MovieAdapter? = MovieAdapter(emptyList())
    lateinit var titleTextView: TextView
    lateinit var countTextView: TextView
    lateinit var descriptionTextView: TextView
    lateinit var selectMoviesButton: Button
    lateinit var footer: TextView
    lateinit var backImageView: ImageView
    lateinit var deleteImageView: ImageView
    lateinit var movieRecyclerView: RecyclerView
    lateinit var oldListOfMovies: ListMovies
    lateinit var newListOfMovies: ListMovies
    var newMoviesId = mutableSetOf<Int>()
    var isNewList = false
    private var isNewListInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val currentListOfMoviesId = arguments?.getString("movieListId")
//        Log.d("PROVA", currentListOfMoviesId ?: "null")
        if (currentListOfMoviesId != null){
            viewModel.getListOfMovies(UUID.fromString(currentListOfMoviesId))
        } else {
            isNewList = true
        }
//        Log.d("PROVA", isNewList.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_list, container, false)
        titleTextView = view.findViewById<TextView?>(R.id.list_title).apply {
            if (isNewList) text = "Введите название для списка"
        }
        countTextView = view.findViewById(R.id.count_tv)
        descriptionTextView = view.findViewById<TextView?>(R.id.description).apply {
            if (isNewList) text = "Введите описание списка"
        }
        selectMoviesButton = view.findViewById<Button?>(R.id.add_movies_btn).apply {
            if (!isNewList) text = "Изменить список фильмов"
        }
        footer = view.findViewById<TextView?>(R.id.footer).apply {
            if (!isNewList){
                text = "Информация о выбранном списке"
            }
            else{
                setOnClickListener {
                    //titleTextView.text.isNotBlank() - даже лишняя проверка, он не может туда ввести пустоту
                    if (titleTextView.text != "Введите название для списка" && titleTextView.text.isNotBlank()
                        && newMoviesId.size != 0) {
                        val newDescription = if (descriptionTextView.text != "Введите описание списка")
                            descriptionTextView.text.toString()
                        else "Описание списка пока что пустое"
                        lifecycleScope.launch {
                            viewModel.createNewListOfMovies(
                                titleTextView.text.toString(),
                                newMoviesId.joinToString(","),
                                newDescription
                            )
                            findNavController().popBackStack()
                        }
                    }
                    else Toast.makeText(requireContext(), "Для создание списка Вы должны ввести название и внести пару фильмов",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        backImageView = view.findViewById<ImageView?>(R.id.back_iv).apply {
            setOnClickListener {
                findNavController().popBackStack()
            }
        }

        deleteImageView = view.findViewById<ImageView?>(R.id.delete_iv).apply {
            if (!isNewList){
                setOnClickListener {
                    showEditDialog(deleteImageView, 4)
                }
            } else isGone = true
        }

        movieRecyclerView = view.findViewById(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = LinearLayoutManager(context)

        titleTextView.setOnClickListener {
            showEditDialog(titleTextView, 1)
        }

        descriptionTextView.setOnClickListener {
            showEditDialog(descriptionTextView, 2)
        }

        selectMoviesButton.setOnClickListener {
            val dialogFragment = MovieSelectorDialogFragment().apply {
                if (!isNewList){
                    if (newListOfMovies.moviesId.isNotEmpty()){
//                    Log.d("MOVIESFRFR", moviesId.toString())
                        arguments = Bundle().apply {
                            putString("SELECTED_MOVIES_STRING", newListOfMovies.moviesId)
                        }
                    }
                }
                else{
                    if (newMoviesId.isNotEmpty()){
//                        Log.d("MOVIESIDSET", newMoviesId.toString())
                        arguments = Bundle().apply {
                            putString("SELECTED_MOVIES_SET", newMoviesId.toString())
                        }
                    }
                }
            }
            dialogFragment.onMoviesSelectedListener = this
            dialogFragment.show(parentFragmentManager, "MovieSelector")
        }

        viewModel.listOfMovies.observe(viewLifecycleOwner){
            if (it == null) return@observe
            oldListOfMovies = it
//            Log.d("DEBUGINITIAL", "List: $it")
            if (!isNewList){
                if (!isNewListInitialized){
                    newListOfMovies = it.copy()
                    isNewListInitialized = true
                    updateUI()
                }
//                Log.d("MovieId", "Observe сработал. Old: $moviesId, New: $newMoviesId")
            }
        }

        //в этом условии прописывать все, что нужно сделать после возврата с фрагмента с деталями выбранного фильма
        if (isNewListInitialized){//нужно для обновления данных после возвращения с фрагмента с деталями фильма
            updateUI()
            doListsDiffer()
        }
        return view
    }

    private fun updateUI(){
        titleTextView.text = newListOfMovies.title
        Log.d("KOLICHE", newListOfMovies.moviesId)
//        val countMovies = newListOfMovies.moviesId.split(",").size
        if (newListOfMovies.moviesId.length == 0) countTextView.text = "Общее количество фильмов: 0"
        else countTextView.text = "Общее количество фильмов: ${newListOfMovies.moviesId.split(",").size}"
        descriptionTextView.text = newListOfMovies.description
        adapter = MovieAdapter(getMovieList(newListOfMovies.moviesId))
        movieRecyclerView.adapter = adapter
    }

    //для случая 0,1,2,3,4, и 1,2,3,4,0, (чтобы эти строки считались одинаковыми)
    private fun doMoviesIdsDiffer(str1: String, str2: String): Boolean {
        if (str1.length != str2.length) return true

        val list1 = str1.split(",").map { it.trim() }.filter { it.isNotEmpty() }.sorted()
        val list2 = str2.split(",").map { it.trim() }.filter { it.isNotEmpty() }.sorted()

        return list1 != list2
    }

    private fun doListsDiffer() {
//        Log.d("DEBUGINITIAL", "Old: $oldListOfMovies")
//        Log.d("DEBUGINITIAL", "New: $newListOfMovies")
//        Log.d("DEBUGINITIAL", "Boolean: ${doMoviesIdsDiffer(oldListOfMovies.moviesId, newListOfMovies.moviesId)}")

//      такая убогая проверка потому что в newListsOfMovies и oldListOfMovies есть отдельное moviesId, которое трубует спец проверки
        if (newListOfMovies.title != oldListOfMovies.title || newListOfMovies.description != oldListOfMovies.description
            || doMoviesIdsDiffer(oldListOfMovies.moviesId, newListOfMovies.moviesId)){
            footer.text = "Прекратить редактирование списка"
            footer.setOnClickListener {
                showEditDialog(footer, 3)
            }
        }
        else{
            footer.text = "Информация о выбранном списке"
            footer.setOnClickListener(null)
        }
    }

    //type==1 => название; type==2 => описание; type==3 => выйти с сохранением?; type==4 => удаление
    private fun showEditDialog(view: View, type: Int) {
        val inputField = EditText(requireContext())
        inputField.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

        if (type == 1){
            val textView = view as TextView
            MaterialAlertDialogBuilder(requireContext(), R.style.DialogTheme)
                .setMessage("Изменение названия списка")
                .setView(inputField)
                .setPositiveButton("Сохранить") { _, _ ->
                    val newText = inputField.text.toString().replace("\n", "")
                    if (newText.isNotBlank()) {
                        if (newText.length > 50)
                            Toast.makeText(requireContext(), "Длина названия не должно превышать 50 символов",
                                Toast.LENGTH_SHORT).show()
                        else{
                            textView.text = newText
                            if (!isNewList) {
                                newListOfMovies.title = newText
                                doListsDiffer()
                            }
                        }
                    }
                }
                .setNegativeButton("Отмена", null)
                .show()
        }

        else if (type == 2){
            val textView = view as TextView
            inputField.setText(textView.text)
            MaterialAlertDialogBuilder(requireContext(), R.style.DialogTheme)
                .setMessage("Изменение описания списка")
                .setView(inputField)
                .setPositiveButton("Сохранить") { _, _ ->
                    var newText = inputField.text.toString()/*.replace("\n\n\n", "\n\n") просто так
                    не пойдет, поскольку если будет 7 подряд \n, то он уберет только 3, а не все 6 нужных*/
                    while ("\n\n\n" in newText) newText = newText.replace("\n\n\n", "\n\n")
                    while (newText.last() == '\n') newText = newText.dropLast(1)
                    if (newText.isNotBlank()){
                        textView.text = newText
                        if (!isNewList) newListOfMovies.description = newText
                    }
                    if (!isNewList) doListsDiffer()
                }
                .setNegativeButton("Отмена", null)
                .show()
        }
        else if (type == 3){
            val textView = view as TextView
            /*AlertDialog.Builder(requireContext(), R.style.DialogTheme)это не совсем подходящее
                .setTitle("Сохранить изменения?")
                .setPositiveButton("Сохранить") { _, _ ->
                    lifecycleScope.launch {
                        viewModel.saveListOfMovies(newListOfMovies) в DAO прописал почему не подходит
                        findNavController().popBackStack()
                    }
                }
                .setNegativeButton("Отмена"){_, _ ->
                    findNavController().popBackStack()
                }
                .show()*/
            MaterialAlertDialogBuilder(requireContext(), R.style.DialogTheme)
                .setMessage("Сохранить изменения?")
                .setPositiveButton("Сохранить") { _, _ ->
                    lifecycleScope.launch {//обновляем по отдельности, чтобы избегать ненужных проблем
                        viewModel.updateTitle(newListOfMovies.id, newListOfMovies.title)
                        viewModel.updateMovies(newListOfMovies.id, newListOfMovies.moviesId)
                        viewModel.updateDescription(newListOfMovies.id, newListOfMovies.description)
                        findNavController().popBackStack()
                    }
                }
                .setNegativeButton("Отмена"){_, _ ->
                    findNavController().popBackStack()
                }
                .show()
        }
        else if (type == 4){
            MaterialAlertDialogBuilder(requireContext(), R.style.DialogTheme)
                .setMessage("Вы уверены, что хотите удалить этот список?")
                .setPositiveButton("Да") { _, _ ->
                    lifecycleScope.launch {
                        viewModel.deleteListOfMovies(newListOfMovies.id)
                        findNavController().popBackStack()
                    }
                }
                .setNegativeButton("Нет", null)
                .show()
        }
    }

    private fun getMovieList(stringIds: String): List<Movie> {
        var listIds: List<Int>
        if (stringIds != "") listIds = stringIds.split(",").map { it.toInt() }
        else return emptyList()
        val listOfMovie:MutableList<Movie> = mutableListOf()
        MovieCatalog.movieList.forEach { movie ->
            if (movie.id in listIds) listOfMovie.add(movie)
        }
        return listOfMovie
    }

    override fun onDestroyView() {
        viewModel.clearListOfMovies()
        viewModel.listOfMovies.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
    }

    private inner class MovieHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        lateinit var movie: Movie

        val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        val yearTextView: TextView = itemView.findViewById(R.id.year)
        val durationTextView: TextView = itemView.findViewById(R.id.duration)
        val ageRatingTextView: TextView = itemView.findViewById(R.id.age_rating)
        val imdbRatingTextView: TextView = itemView.findViewById(R.id.imdb_rating)
        val kinopoiskRatingTextView: TextView = itemView.findViewById(R.id.kinopoisk_rating)
        val genresTextView: TextView = itemView.findViewById(R.id.genres)
        val moviePoster = itemView.findViewById<ImageView>(R.id.movie_poster)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie){
            this.movie = movie
            titleTextView.text = movie.title
            yearTextView.text = movie.year.toString()
            durationTextView.text = normalizeDuration(movie.duration)
            ageRatingTextView.text = movie.ageRating
            imdbRatingTextView.text = movie.rateIMDB.toString()
            kinopoiskRatingTextView.text = movie.rateKinopoisk.toString()
            genresTextView.text = normalizeGenres(movie.genres)
            Glide.with(this@DetailListFragment).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(moviePoster)
        }

        override fun onClick(v: View?) {
            if (!isNewList){
                val movieId = movie.id
                val bundle = bundleOf("movieId" to movieId)
                findNavController().navigate(R.id.action_detailListFragment_to_movieFragment, bundle)
            }else{//не стал париться, пусть в создании при нажатии на фильм, он удаляется
                newMoviesId.remove(movie.id)
                adapter = MovieAdapter(getSetMoviesFromSetOfIds(newMoviesId).toList())
                movieRecyclerView.adapter = adapter
                countTextView.text = "Общее количество фильмов: ${newMoviesId.size}"
            }
        }
    }

    private inner class MovieAdapter(var movies: List<Movie>): RecyclerView.Adapter<MovieHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
            val view = layoutInflater.inflate(R.layout.list_item_movie, parent, false)
            return MovieHolder(view)
        }

        override fun getItemCount() = movies.size

        override fun onBindViewHolder(holder: MovieHolder, position: Int) {
            val movie = movies[position]
            holder.bind(movie)
        }
    }

    fun getSetMoviesFromSetOfIds(selectedMoviesId: Set<Int>): Set<Movie>{
        val listOfMovie = mutableSetOf<Movie>()//все, что ниже - для установки выбранных фильмов в RecyclerView
        MovieCatalog.movieList.forEach { movie ->
            if (movie.id in selectedMoviesId) listOfMovie.add(movie)
        }
        return listOfMovie
    }

    override fun onMoviesSelected(selectedMoviesId: Set<Int>) {
        newMoviesId = selectedMoviesId.toMutableSet()//нужен для сохранения в базу данных в дальнейшем
        if (!isNewList) newListOfMovies.moviesId = selectedMoviesId.joinToString(",")
        countTextView.text = "Общее количество фильмов: ${selectedMoviesId.size}"
        adapter = MovieAdapter(getSetMoviesFromSetOfIds(selectedMoviesId).toList())
        movieRecyclerView.adapter = adapter
        if (!isNewList) doListsDiffer()
    }
}