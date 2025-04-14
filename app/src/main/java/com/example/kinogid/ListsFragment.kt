package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        val watchedMovieList = view.findViewById<ConstraintLayout>(R.id.watched_movies_list)

        viewModel.getListWatchedMovies()
        viewModel.listWatchedMovies.observe(viewLifecycleOwner){ listOfMoviesId ->
            controlWatchedMoviesField(listOfMoviesId)//передаст null, если list == null
//            Log.d("DEBUGSIZE", "В observe ${listOfMoviesId?.size.toString()}")
        }

        watchedMovieList.setOnClickListener{
            if (viewModel.listWatchedMovies.value?.size != 0)
                findNavController().navigate(R.id.action_menu_lists_to_detailListFragment)
        }

        return view
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