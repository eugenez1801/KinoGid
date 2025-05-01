package com.example.kinogid

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.kinogid.movies.Genre
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MovieFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    lateinit var movie: Movie
    var userRatingStatus: Int? = 1//отслеживаем этот статус для изменения  !UI!
    lateinit var currentDiaryText: String
    var isEditMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val currentMovieId = arguments?.getInt("movieId")
        movie = MovieCatalog.movieList.find { it.id == currentMovieId } !!
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val user = viewModel.user.value!!

        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        val titleTextView = view.findViewById<TextView>(R.id.movie_title).apply { text = movie.title }

        val genresTextView = view.findViewById<TextView>(R.id.movie_genres).apply {
            text = normalizeGenresDetail(movie.genres)
        }

        val moviePoster = view.findViewById<ImageView>(R.id.movie_poster)

        val yearTextView = view.findViewById<TextView>(R.id.year_tv).apply {
            text = movie.year.toString()
        }

        val durationTextView = view.findViewById<TextView>(R.id.duration_tv).apply {
            text = normalizeDuration(movie.duration)
        }

        val ageRatingTextView = view.findViewById<TextView>(R.id.age_rating_tv).apply {
            text = movie.ageRating
        }

        val imdbRatingTextView = view.findViewById<TextView>(R.id.imdb_rating_tv).apply {
            text = movie.rateIMDB.toString()
        }

        val kinopoiskRatingTextView = view.findViewById<TextView>(R.id.kinopoisk_rating_tv).apply {
            text = movie.rateKinopoisk.toString()
        }

        val oscarsTextView = view.findViewById<TextView>(R.id.oscars_tv).apply {
            if (movie.oscarsCount != 0) {
                text = "${movie.oscarsCount}x"
                if(movie.globesCount == 0) (layoutParams as? ViewGroup.MarginLayoutParams)
                    ?.rightMargin = 0//избавиться от маржина
            }
            else isGone = true
        }

        val globesTextView = view.findViewById<TextView>(R.id.globes_tv).apply {
            if (movie.globesCount != 0) text = "${movie.globesCount.toString()}x"
            else isGone = true
        }

        val descriptionTextView = view.findViewById<TextView>(R.id.description_tv).apply {
            var descriptionText = "   ${movie.description}".replace("\n", "\n   ")
//            if ("\n" in descriptionText) descriptionText.replace("\n", "\n   ")
            text = descriptionText
        }

        Glide.with(this).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
            .into(moviePoster)

        val footer = view.findViewById<TextView>(R.id.footer).apply {
            setOnClickListener {
                findNavController().popBackStack()
            }
        }

        viewModel.getWatchedMovie(movie.id)//задаем значение для viewModel.watchedMovie
        val watchedLinearLayout = view.findViewById<LinearLayout>(R.id.watched_field)
        val watchedImageView = view.findViewById<ImageView>(R.id.watched_ic)/*.apply {
            if (viewModel.watchedMovie.value == null) setBackgroundResource(R.drawable.ic_not_watched)
            else setBackgroundResource(R.drawable.ic_watched) это было бессмысленно, поскольку
            viewModel.getWatchedMovie(movie.id) не всегда успевало отработать, поэтому ввод данных
            для watchedImageView и watchedTextView был выведен в watchedMovie.observe
        }*/
        val watchedTextView = view.findViewById<TextView>(R.id.watched_tv)/*.apply {
            if (viewModel.watchedMovie.value == null) text = "Фильм еще не просмотрен"
            else text = "Фильм просмотрен"
        }*/

        val userRatingLinearLayout = view.findViewById<LinearLayout>(R.id.user_rating)
        val userRatingImageView = view.findViewById<ImageView>(R.id.user_rating_iv)

        val diaryTextView = view.findViewById<TextView>(R.id.user_diary_tv)
        val diaryEdit = view.findViewById<TextInputEditText>(R.id.user_diary_edit)
        diaryEdit.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        val diaryCancelTextView = view.findViewById<TextView>(R.id.cancel_tv)
        val diarySaveTextView = view.findViewById<TextView>(R.id.save_tv)

        fun closeEditMode(){
            isEditMode = false
            diaryTextView.apply {
                isGone = false
                if (currentDiaryText.isNotBlank()) text = currentDiaryText
                else text = "Вы не писали заметок. Нажмите на заголовок выше для редактирования."
            }
            diaryEdit.isGone = true
            diaryCancelTextView.isGone = true
            diarySaveTextView.isGone = true
        }

        fun openEditMode(){
            isEditMode = true
            diaryTextView.isGone = true
            diaryEdit.apply {
                isGone = false
                setText(currentDiaryText)
            }
            diaryCancelTextView.apply {
                isGone = false
                setOnClickListener {
                    closeEditMode()
                }
            }
            diarySaveTextView.apply {
                isGone = false
                setOnClickListener {
                    var newDiaryText = diaryEdit.text.toString()
                    while ("\n\n\n" in newDiaryText) newDiaryText = newDiaryText.replace("\n\n\n", "\n\n")
                    viewModel.updateDiaryText(movie.id, newDiaryText)
                    currentDiaryText = newDiaryText
                    closeEditMode()
                }
            }
        }

        val diaryTitleTextView = view.findViewById<TextView>(R.id.user_diary).apply {
            setOnClickListener {
                when(isEditMode ){
                    true -> closeEditMode()
                    false -> openEditMode()
                }
            }
        }

        viewModel.watchedMovie.observe(viewLifecycleOwner){
            userRatingStatus = it?.userRating//задаем начальное значение для дальнейшей работы с UI
            currentDiaryText = it?.diaryText.toString()

            watchedImageView.apply {
                if (viewModel.watchedMovie.value == null) setBackgroundResource(R.drawable.ic_not_watched)
                else setBackgroundResource(R.drawable.ic_watched)
            }
            watchedTextView.apply {
                if (viewModel.watchedMovie.value == null) text = "Фильм еще не просмотрен"
                else text = "Фильм просмотрен"
            }

            userRatingLinearLayout.apply {
                if (viewModel.watchedMovie.value == null) isGone = true
                else {
                    isGone = false
                    userRatingImageView.apply {
                        when (it?.userRating){
                            1 -> setBackgroundResource(R.drawable.ic_neutral_face)
                            2 -> setBackgroundResource(R.drawable.ic_like)
                            3 -> setBackgroundResource(R.drawable.ic_dislike)
                        }
                    }
                }
            }

            diaryTitleTextView.apply {
                if (viewModel.watchedMovie.value == null) isGone = true
                else isGone = false
            }

            diaryTextView.apply {
                if (viewModel.watchedMovie.value == null) isGone = true
                else{
                    isGone = false
                    if (it?.diaryText == "") text = "Вы не писали заметок. Нажмите на заголовок выше для редактирования."
                    else text = it?.diaryText
                }
            }
        }

        watchedLinearLayout.setOnClickListener{
            if (viewModel.watchedMovie.value != null){
                MaterialAlertDialogBuilder(requireContext(), R.style.DialogTheme)
                    .setMessage("Вы уверены, что хотите исключить фильм из списка просмотренных?")
                    .setPositiveButton("Да") { _, _ ->
                        viewModel.updateStatusWatchedMovie(movie.id) { resultCode ->
                            if (resultCode == 1) {
                                watchedImageView.setBackgroundResource(R.drawable.ic_watched)
                                watchedTextView.text = "Фильм просмотрен"
                            } else {
                                watchedImageView.setBackgroundResource(R.drawable.ic_not_watched)
                                watchedTextView.text = "Фильм еще не просмотрен"
                            }
                        }
                    }
                    .setNegativeButton("Нет", null).show()
            }
            else{
                viewModel.updateStatusWatchedMovie(movie.id){ resultCode ->
                    if (resultCode == 1){
                        watchedImageView.setBackgroundResource(R.drawable.ic_watched)
                        watchedTextView.text = "Фильм просмотрен"
                    }
                    else {
                        watchedImageView.setBackgroundResource(R.drawable.ic_not_watched)
                        watchedTextView.text = "Фильм еще не просмотрен"
                    }
                }
            }
        }

        userRatingLinearLayout.setOnClickListener{
            when (userRatingStatus){
                1 -> {
                    viewModel.updateUserRating(movie.id, 2)//обновление для базы данных
                    userRatingStatus = 2//обновление для этого фрагмента
                    userRatingImageView.setBackgroundResource(R.drawable.ic_like)
                }
                2 -> {
                    viewModel.updateUserRating(movie.id, 3)
                    userRatingStatus = 3
                    userRatingImageView.setBackgroundResource(R.drawable.ic_dislike)
                }
                3 -> {
                    viewModel.updateUserRating(movie.id, 1)
                    userRatingStatus = 1
                    userRatingImageView.setBackgroundResource(R.drawable.ic_neutral_face)
                }
            }
//            viewModel.getWatchedMovie(movie.id) не всегда успевает почему то
        }
        return view
    }

    fun normalizeGenresDetail(genres: Set<Genre>):String{
        var result: String = ""
        for (genre in genres){
            if (genre != genres.last()) result += "${genre.displayingGenre}   "
            else result += "${genre.displayingGenre}"
        }
        return result
    }
}