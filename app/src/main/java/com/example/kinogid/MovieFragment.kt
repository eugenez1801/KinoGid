package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        return view
    }
}