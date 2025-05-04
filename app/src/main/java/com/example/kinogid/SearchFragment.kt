package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

        //больше никогда обычный SearchView не юзать (брать из Material, либо AppCompat)
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val searchTextId = searchView.context.resources
            .getIdentifier("android:id/search_src_text", null, null)
        val searchText = searchView.findViewById<AutoCompleteTextView>(searchTextId)
        searchText.setTextColor(ContextCompat.getColor(requireContext(), R.color.secondaryColor))
        searchText.setHintTextColor(ContextCompat.getColor(requireContext(), R.color.secondaryColorHint))

        val searchIconId = searchView.context.resources
            .getIdentifier("android:id/search_mag_icon", null, null)
        val searchIcon = searchView.findViewById<ImageView>(searchIconId)
        searchIcon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.secondaryColor))

        val closeButtonId = searchView.context.resources
            .getIdentifier("android:id/search_close_btn", null, null)
        val closeButton = searchView.findViewById<ImageView>(closeButtonId)
        closeButton.setColorFilter(ContextCompat.getColor(requireContext(), R.color.secondaryColor))

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
            Glide.with(this@SearchFragment).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(moviePoster)
        }

        override fun onClick(v: View?) {
            val movieId = movie.id
            val bundle = bundleOf("movieId" to movieId)
            findNavController().navigate(R.id.action_menu_search_to_movieFragment, bundle)
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
}