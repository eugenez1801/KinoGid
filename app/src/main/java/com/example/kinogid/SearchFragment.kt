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
import com.example.kinogid.movies.Genre
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
            durationTextView.text = normalizeDuration(movie.duration)
            ageRatingTextView.text = movie.ageRating
            imdbRatingTextView.text = movie.rateIMDB.toString()
            kinopoiskRatingTextView.text = movie.rateKinopoisk.toString()
            genresTextView.text = normalizeGenres(movie.genres)
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

    private fun filterList(text: String?): List<Movie> {
        if (text.isNullOrBlank()) return emptyList()
        val startWithList: MutableList<Movie> = mutableListOf()//список для фильмов, начинающихся с этих букв
        val filteredList: MutableList<Movie> = mutableListOf()
        val lowerText = text.lowercase().replace('ё', 'е')
        MovieCatalog.movieList.forEach { movie ->
            val movieName = movie.title.lowercase().replace('ё', 'е')
            if (movieName.startsWith(lowerText))
                startWithList.add(movie)
            else if (lowerText in movieName)
                filteredList.add(movie)
        }
        return startWithList + filteredList
    }

    fun normalizeDuration(duration: Int): String{
        if (duration < 60) return "${duration.toString()} мин"
        val hours = duration / 60
        val minutes = duration % 60
        return ("$hours ч $minutes мин ")
    }

    fun normalizeGenres(genres: Set<Genre>): String{
        var result = ""
        if(Genre.ACTION in genres) result += "${Genre.ACTION.displayingGenre}, "
        if(Genre.ADVENTURE in genres) result += "${Genre.ADVENTURE.displayingGenre}, "
        if(Genre.ANIMATION in genres) result += "${Genre.ANIMATION.displayingGenre}, "
        if(Genre.BIOGRAPHY in genres) result += "${Genre.BIOGRAPHY.displayingGenre}, "
        if(Genre.COMEDY in genres) result += "${Genre.COMEDY.displayingGenre}, "
        if(Genre.CRIME in genres) result += "${Genre.CRIME.displayingGenre}, "
        if(Genre.DOCUMENTARY in genres) result += "${Genre.DOCUMENTARY.displayingGenre}, "
        if(Genre.DRAMA in genres) result += "${Genre.DRAMA.displayingGenre}, "
        if(Genre.FAMILY in genres) result += "${Genre.FAMILY.displayingGenre}, "
        if(Genre.FANTASY in genres) result += "${Genre.FANTASY.displayingGenre}, "
        if(Genre.HORROR in genres) result += "${Genre.HORROR.displayingGenre}, "
        if(Genre.MUSICAL in genres) result += "${Genre.MUSICAL.displayingGenre}, "
        if(Genre.MYSTERY in genres) result += "${Genre.MYSTERY.displayingGenre}, "
        if(Genre.ROMANCE in genres) result += "${Genre.ROMANCE.displayingGenre}, "
        if(Genre.SCI_FI in genres) result += "${Genre.SCI_FI.displayingGenre}, "
        if(Genre.SPORT in genres) result += "${Genre.SPORT.displayingGenre}, "
        if(Genre.SUPERHERO in genres)result += "${Genre.SUPERHERO.displayingGenre}, "
        if(Genre.THRILLER in genres) result += "${Genre.THRILLER.displayingGenre}, "
        if(Genre.WAR in genres) result += "${Genre.WAR.displayingGenre}, "
        if(Genre.WESTERN in genres) result += "${Genre.WESTERN.displayingGenre}, "
        result = result.removeSuffix(", ")
        return result
    }
}