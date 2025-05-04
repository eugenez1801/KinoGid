package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog

class ListsFragment: Fragment() {
    lateinit var viewModel: MainViewModel

    lateinit var firstImageView: ImageView
    lateinit var secondImageView: ImageView
    lateinit var thirdImageView: ImageView
    lateinit var fourthImageView: ImageView
    lateinit var counterTextView: TextView
    lateinit var emptyListTextView: TextView
    lateinit var addListImageView: ImageView
    lateinit var counterListsTextView: TextView
    lateinit var listRecyclerView: RecyclerView

    private var adapter: MovieListAdapter? = MovieListAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_lists, container, false)
        firstImageView = view.findViewById(R.id.first_movie_poster)
        secondImageView = view.findViewById(R.id.second_movie_poster)
        thirdImageView = view.findViewById(R.id.third_movie_poster)
        fourthImageView = view.findViewById(R.id.fourth_movie_poster)
        counterTextView = view.findViewById(R.id.count_tv)
        emptyListTextView = view.findViewById(R.id.empty_tv)
        addListImageView = view.findViewById(R.id.add_list)
        val watchedMovieList = view.findViewById<ConstraintLayout>(R.id.watched_movies_list)

        counterListsTextView = view.findViewById(R.id.user_lists_tv)
        listRecyclerView = view.findViewById(R.id.list_recycler_view)
        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = adapter

        viewModel.getListIdWatchedMovies()
        viewModel.listWatchedMovies.observe(viewLifecycleOwner){ listOfMoviesId ->
            controlWatchedMoviesField(listOfMoviesId)//передаст null, если list == null
//            Log.d("DEBUGSIZE", "В observe ${listOfMoviesId?.size.toString()}")
        }

        watchedMovieList.setOnClickListener{
            if (viewModel.listWatchedMovies.value?.size != 0)
                findNavController().navigate(R.id.action_menu_lists_to_detailWatchedListFragment)
        }

        addListImageView.setOnClickListener {
            findNavController().navigate(R.id.action_menu_lists_to_detailListFragment)
        }

        viewModel.getUserLists()
        viewModel.listOfListsMovies.observe(viewLifecycleOwner){ listOfListsMovies ->
            adapter = MovieListAdapter(listOfListsMovies)
            listRecyclerView.adapter = adapter
            counterListsTextView.text = "Количество пользовательских списков: ${listOfListsMovies.size}"
        }

        return view
    }

    private inner class MovieListHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        lateinit var moviesList: ListMovies

        val titleTextView: TextView = itemView.findViewById(R.id.list_name)
        val countTextView: TextView = itemView.findViewById(R.id.count_tv)
        val firstPoster: ImageView = itemView.findViewById(R.id.first_movie_poster)
        val secondPoster: ImageView = itemView.findViewById(R.id.second_movie_poster)
        val thirdPoster: ImageView = itemView.findViewById(R.id.third_movie_poster)
        val fourthPoster: ImageView = itemView.findViewById(R.id.fourth_movie_poster)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(moviesList: ListMovies){
            this.moviesList = moviesList
            titleTextView.text = moviesList.title

            //очень некрасиво, но пусть будет
            val firstId = getSetIds(moviesList.moviesId).elementAtOrNull(0)
            val firstMovie = MovieCatalog.movieList.firstOrNull {
                it.id == firstId
            }
            if (firstMovie != null){
                firstPoster.isGone = false
                Glide.with(this@ListsFragment).load(firstMovie.posterURL)
                    .placeholder(R.drawable.ic_load_placeholder).into(firstPoster)
            }
            else firstPoster.isGone = true//нужно подумать, isGone или просто visibility

            val secondId = getSetIds(moviesList.moviesId).elementAtOrNull(1)
            val secondMovie = MovieCatalog.movieList.firstOrNull {
                it.id == secondId
            }
            if (secondMovie != null){
                secondPoster.isGone = false
                Glide.with(this@ListsFragment).load(secondMovie.posterURL)
                    .placeholder(R.drawable.ic_load_placeholder).into(secondPoster)
            }
            else secondPoster.isGone = true

            val thirdId = getSetIds(moviesList.moviesId).elementAtOrNull(2)
            val thirdMovie = MovieCatalog.movieList.firstOrNull {
                it.id == thirdId
            }
            if (thirdMovie != null){
                thirdPoster.isGone = false
                Glide.with(this@ListsFragment).load(thirdMovie.posterURL)
                    .placeholder(R.drawable.ic_load_placeholder).into(thirdPoster)
            }
            else thirdPoster.isGone = true

            val fourthId = getSetIds(moviesList.moviesId).elementAtOrNull(3)
            val fourthMovie = MovieCatalog.movieList.firstOrNull {
                it.id == fourthId
            }
            if (fourthMovie != null) {
                fourthPoster.isGone = false
                Glide.with(this@ListsFragment).load(fourthMovie.posterURL)
                    .placeholder(R.drawable.ic_load_placeholder).into(fourthPoster)
            }
            else fourthPoster.isGone = true

            val idsMovies = getSetIds(moviesList.moviesId)
            if (idsMovies.size == 0) countTextView.text = "Этот список пустой. Нажмите, чтобы " +
                    "перейти к его редактированию и добавить в него фильмы"
            else countTextView.text = "Фильмов в списке: ${idsMovies.size}"
        }

        override fun onClick(v: View?) {
            val movieListId = moviesList.id
            val bundle = bundleOf("movieListId" to movieListId.toString())
            findNavController().navigate(R.id.action_menu_lists_to_detailListFragment, bundle)
        }
    }

    private fun getSetIds(stringIds: String): Set<Int> {
        if (stringIds != "") return stringIds.split(",").map { it.toInt() }.toSet()
        else return emptySet()
    }

    private inner class MovieListAdapter(var moviesList: List<ListMovies>): RecyclerView.Adapter<MovieListHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListHolder {
            val view = layoutInflater.inflate(R.layout.list_item_list_of_movies, parent, false)
            return MovieListHolder(view)
        }

        override fun getItemCount() = moviesList.size

        override fun onBindViewHolder(holder: MovieListHolder, position: Int) {
            val movieList = moviesList[position]
            holder.bind(movieList)
        }
    }

    private fun controlWatchedMoviesField(listOfId: List<Int>?){
//        Log.d("DEBUGSIZE", "В методе $size")
        val size = listOfId?.size
        val listOfMovie = createListOfMovies(listOfId)
        if (size == null || size == 0) {
            firstImageView.isGone = true
            secondImageView.isGone = true
            thirdImageView.isGone = true
            fourthImageView.isGone = true
            counterTextView.isGone = true
            emptyListTextView.isVisible = true
        }

        else if (size >= 4){
            Glide.with(this).load(listOfMovie[0].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(firstImageView)
            Glide.with(this).load(listOfMovie[1].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(secondImageView)
            Glide.with(this).load(listOfMovie[2].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(thirdImageView)
            Glide.with(this).load(listOfMovie[3].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(fourthImageView)
        }

        else if (size == 3){
            Glide.with(this).load(listOfMovie[0].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(firstImageView)
            Glide.with(this).load(listOfMovie[1].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(secondImageView)
            Glide.with(this).load(listOfMovie[2].posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(thirdImageView)
        }

        else if (size == 2) {
            Glide.with(this).load(listOfMovie[0].posterURL)
                .placeholder(R.drawable.ic_load_placeholder)
                .into(firstImageView)
            Glide.with(this).load(listOfMovie[1].posterURL)
                .placeholder(R.drawable.ic_load_placeholder)
                .into(secondImageView)
        }

        else if (size == 1) {
            Glide.with(this).load(listOfMovie[0].posterURL)
                .placeholder(R.drawable.ic_load_placeholder)
                .into(firstImageView)
        }
        counterTextView.text = "Общее количество: $size"
    }

    private fun createListOfMovies(listOfId: List<Int>?):List<Movie>{
        val listOfMovie:MutableList<Movie> = mutableListOf()
        MovieCatalog.movieList.forEach { movie ->
            if (movie.id in listOfId!!) listOfMovie.add(movie)
        }
        listOfMovie.shuffle()
        return listOfMovie
    }
}