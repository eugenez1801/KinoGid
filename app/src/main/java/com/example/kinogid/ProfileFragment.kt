package com.example.kinogid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.kinogid.movies.Genre
import kotlinx.coroutines.launch

class ProfileFragment: Fragment(), GenreSelectorDialogFragment.OnGenresSelectedListener {
    private lateinit var preferencesManager: PreferencesManager
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preferencesManager = PreferencesManager(requireContext())

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val user = viewModel.user.value!!

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val nameField = view.findViewById<TextView>(R.id.name_field)
        val preferencesField = view.findViewById<TextView>(R.id.preferences_field)
        val exitImageView = view.findViewById<ImageView>(R.id.exit)

        viewModel.getUserPreferences()
        nameField.text = "Имя: ${user.name}"

        preferencesField.setOnClickListener{
            val userPreferences = viewModel.userPreferences.value
            val dialogFragment = GenreSelectorDialogFragment().apply {
                arguments = Bundle().apply {
                    putString("usersGenres", userPreferences?.genres)
                }
            }
            dialogFragment.setOnGenreSelectedListener(this)
            dialogFragment.show(parentFragmentManager, "GenreSelector")
        }

        viewModel.userPreferences.observe(viewLifecycleOwner){
            preferencesField.text = createPreferencesText(it?.genres)

        }

        exitImageView.setOnClickListener{
            lifecycleScope.launch {
                preferencesManager.clearSession()
                val intent= Intent(requireContext(), AuthActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }
        return view
    }

    fun createPreferencesText(genres: String?): String{
        if (genres == null || genres == "") return "Любимых жанров пока нет"
        var result = "Любимые жанры: "
        if("ACTION" in genres) result += "${Genre.ACTION.displayingGenre}, "
        if("ADVENTURE" in genres) result += "${Genre.ADVENTURE.displayingGenre}, "
        if("ANIMATION" in genres) result += "${Genre.ANIMATION.displayingGenre}, "
        if("BIOGRAPHY" in genres) result += "${Genre.BIOGRAPHY.displayingGenre}, "
        if("COMEDY" in genres) result += "${Genre.COMEDY.displayingGenre}, "
        if("CRIME" in genres) result += "${Genre.CRIME.displayingGenre}, "
        if("DOCUMENTARY" in genres) result += "${Genre.DOCUMENTARY.displayingGenre}, "
        if("DRAMA" in genres) result += "${Genre.DRAMA.displayingGenre}, "
        if("FAMILY" in genres) result += "${Genre.FAMILY.displayingGenre}, "
        if("FANTASY" in genres) result += "${Genre.FANTASY.displayingGenre}, "
        if("HORROR" in genres) result += "${Genre.HORROR.displayingGenre}, "
        if("MUSICAL" in genres) result += "${Genre.MUSICAL.displayingGenre}, "
        if("MYSTERY" in genres) result += "${Genre.MYSTERY.displayingGenre}, "
        if("ROMANCE" in genres) result += "${Genre.ROMANCE.displayingGenre}, "
        if("SCI_FI" in genres) result += "${Genre.SCI_FI.displayingGenre}, "
        if("SPORT" in genres) result += "${Genre.SPORT.displayingGenre}, "
        if("SUPERHERO" in genres)result += "${Genre.SUPERHERO.displayingGenre}, "
        if("THRILLER" in genres) result += "${Genre.THRILLER.displayingGenre}, "
        if("WAR" in genres) result += "${Genre.WAR.displayingGenre}, "
        if("WESTERN" in genres) result += "${Genre.WESTERN.displayingGenre}, "
        result = result.removeSuffix(", ") + "."
        return result
    }

    override fun onGenresSelected(selectedGenres: Set<Genre>) {
        viewModel.updateSelectedGenres(selectedGenres)
    }
}