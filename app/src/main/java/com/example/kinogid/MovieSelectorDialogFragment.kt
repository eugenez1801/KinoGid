package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog

class MovieSelectorDialogFragment: DialogFragment() {
    private var adapter: MovieAdapter? = MovieAdapter(MovieCatalog.movieList)
    private val movieIdSet = mutableSetOf<Int>()
    lateinit var countTextView: TextView
    lateinit var cancelButton: Button
    lateinit var saveButton: Button

    interface OnMoviesSelectedListener {
        fun onMoviesSelected(selectedMoviesId: Set<Int>)
    }

    var onMoviesSelectedListener: OnMoviesSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_movies_selection, container, false)
        countTextView = view.findViewById(R.id.count_tv)
        cancelButton = view.findViewById(R.id.cancel_button)
        saveButton = view.findViewById(R.id.save_button)

        val movieRecyclerView = view.findViewById<RecyclerView>(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = LinearLayoutManager(context)
        movieRecyclerView.adapter = adapter

        cancelButton.setOnClickListener{
            dismiss()
        }

        saveButton.setOnClickListener{
            onMoviesSelectedListener?.onMoviesSelected(movieIdSet)
            dismiss()
        }

        return view
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
        val moviePoster = view.findViewById<ImageView>(R.id.movie_poster)

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
            Glide.with(this@MovieSelectorDialogFragment).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(moviePoster)
        }

        override fun onClick(v: View?) {
            val movieId = movie.id
            if (movieId !in movieIdSet) {
                titleTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                movieIdSet.add(movieId)
            }
            else{
                titleTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.secondaryColor))
                movieIdSet.remove(movieId)
            }
            countTextView.text = "Выбрано фильмов: ${movieIdSet.size}"
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

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}