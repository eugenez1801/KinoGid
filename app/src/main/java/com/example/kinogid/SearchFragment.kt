package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog

class SearchFragment: Fragment() {
    private var adapter: MovieAdapter? = MovieAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val searchView = view.findViewById<SearchView>(R.id.searchView)

        val movieRecyclerView = view.findViewById<RecyclerView>(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = LinearLayoutManager(context)
        movieRecyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter = MovieAdapter(filterList(newText))
                movieRecyclerView.adapter = adapter
                return true
            }
        })

        return view
    }

    private fun filterList(text: String?): List<Movie> {
        if (text == null || text.isBlank()) return emptyList()
        var filteredList: MutableList<Movie> = mutableListOf()
        val lowerText = text.lowercase()
        MovieCatalog.movieList.forEach { movie ->
            if (lowerText in movie.title.lowercase()) filteredList.add(movie)
        }
        return filteredList
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

        fun bind(movie: Movie){
            this.movie = movie
            titleTextView.text = movie.title
            yearTextView.text = movie.year.toString()//на предупреждение пофиг наверное
            durationTextView.text = movie.duration.toString()//нужно настроить на показ времени в часах (ч мин)
            ageRatingTextView.text = movie.ageRating
            imdbRatingTextView.text = movie.rateIMDB.toString()
            kinopoiskRatingTextView.text = movie.rateKinopoisk.toString()
            genresTextView.text = movie.genres.toString()//нужно настроить на норм показ
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
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
}