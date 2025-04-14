package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog

class DetailListFragment: Fragment() {
    lateinit var viewModel: MainViewModel
    private var adapter: MovieAdapter? = MovieAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_detail_list, container, false)

        val movieRecyclerView = view.findViewById<RecyclerView>(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = LinearLayoutManager(context)
        /*viewModel.getListWatchedMovies()Не нужно, поскольку список везде где надо обновляется сам*/
        val listOfMovies = createListOfMovies(viewModel.listWatchedMovies.value)
        adapter = MovieAdapter(listOfMovies)
        movieRecyclerView.adapter = adapter

        val countTextView = view.findViewById<TextView>(R.id.count_tv).apply {
            text = "Общее количество: ${listOfMovies.size}"
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
            yearTextView.text = movie.year.toString()//на предупреждение пофиг наверное
            durationTextView.text = normalizeDuration(movie.duration)
            ageRatingTextView.text = movie.ageRating
            imdbRatingTextView.text = movie.rateIMDB.toString()
            kinopoiskRatingTextView.text = movie.rateKinopoisk.toString()
            genresTextView.text = normalizeGenres(movie.genres)
            Glide.with(this@DetailListFragment).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(moviePoster)
        }

        override fun onClick(v: View?) {
            val movieId = movie.id
            val bundle = bundleOf("movieId" to movieId)
            findNavController().navigate(R.id.action_detailListFragment_to_movieFragment, bundle)
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

    private fun createListOfMovies(listOfId: List<Int>?):List<Movie>{
        val listOfMovie:MutableList<Movie> = mutableListOf()
        MovieCatalog.movieList.forEach { movie ->
            if (movie.id in listOfId!!) listOfMovie.add(movie)
        }
        /*listOfMovie.shuffle() Здесь не нужно*/
        return listOfMovie
    }
}