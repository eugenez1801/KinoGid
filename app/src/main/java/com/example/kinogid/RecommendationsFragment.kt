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

class RecommendationsFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    private var adapter: MovieAdapter? = MovieAdapter(emptyList())
    lateinit var movieRecyclerView: RecyclerView
    lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("Chekau", "Start")
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
//        viewModel.updateListOfRecommendation() пусть будет только в onResume
    }

    override fun onResume() {
        super.onResume()
//        Log.d("Chekau", "Resume")
        viewModel.updateListOfRecommendation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_recommendations, container, false)
        val nameTextView = view.findViewById<TextView>(R.id.name_text)
        infoTextView = view.findViewById(R.id.info_tv)
        movieRecyclerView = view.findViewById(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.listOfRecommendation.observe(viewLifecycleOwner){ movieList ->
//            Log.d("Chekau", "Список, пришедший во фрагмент: ${movieList.toString()}")
            adapter = MovieAdapter(movieList)
            movieRecyclerView.adapter = adapter
            infoTextView.text = if (movieList.isEmpty()) "К сожалению, у нас пока недостаточно " +
                    "информации о Ваших предпочтениях, чтобы составить персональные рекомендации. " +
                    "Просим Вас отметить уже просмотренные фильмы при помощи раздела \"Поиск\", " +
                    "а также в разделе \"Мой профиль\" указать любимые жанры."
            else "Список рекомендаций"
        }

        val user = viewModel.user.value!!
        nameTextView.text = "${user.name}!"

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
        val moviePoster = itemView.findViewById<ImageView>(R.id.movie_poster)

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
            Glide.with(this@RecommendationsFragment).load(movie.posterURL).placeholder(R.drawable.ic_load_placeholder)
                .into(moviePoster)
        }

        override fun onClick(p0: View?) {
            val movieId = movie.id
            val bundle = bundleOf("movieId" to movieId)
            findNavController().navigate(R.id.action_menu_recommendations_to_movieFragment, bundle)
        }
    }

    private inner class MovieAdapter(var movies: List<Movie>): RecyclerView.Adapter<MovieHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
            val view = layoutInflater.inflate(R.layout.list_item_movie, parent, false)
            return MovieHolder(view)
        }

        override fun getItemCount(): Int {
            return movies.size
        }

        override fun onBindViewHolder(holder: MovieHolder, position: Int) {
            val movie = movies[position]
            holder.bind(movie)
        }
    }
}