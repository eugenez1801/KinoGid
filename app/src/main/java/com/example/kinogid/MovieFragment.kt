package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kinogid.movies.Genre
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog

class MovieFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    lateinit var movie: Movie

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
        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        val titleTextView = view.findViewById<TextView>(R.id.movie_title).apply { text = movie.title }

        val genresTextView = view.findViewById<TextView>(R.id.movie_genres).apply {
            text = normalizeGenresDetail(movie.genres)
        }

        val moviePoster = view.findViewById<ImageView>(R.id.moviePoster)

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

        Glide.with(this).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
            .into(moviePoster)
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