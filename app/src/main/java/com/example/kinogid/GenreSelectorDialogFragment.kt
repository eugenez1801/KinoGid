package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.kinogid.movies.Genre
import com.google.android.material.chip.Chip

class GenreSelectorDialogFragment: DialogFragment() {
    interface OnGenresSelectedListener {
        fun onGenresSelected(selectedGenres: Set<Genre>)
    }

    var onGenresSelectedListener: OnGenresSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val usersGenres = arguments?.getString("usersGenres")

        val view = inflater.inflate(R.layout.dialog_genres_selection, container, false)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)
        val saveButton = view.findViewById<Button>(R.id.save_button)
        val chipAction = view.findViewById<Chip>(R.id.action_chip)
        val chipAdventure = view.findViewById<Chip>(R.id.adventure_chip)
        val chipAnimation = view.findViewById<Chip>(R.id.animation_chip)
        val chipBiography = view.findViewById<Chip>(R.id.biography_chip)
        val chipComedy = view.findViewById<Chip>(R.id.comedy_chip)
        val chipCrime = view.findViewById<Chip>(R.id.crime_chip)
        val chipDocumentary = view.findViewById<Chip>(R.id.documentary_chip)
        val chipDrama = view.findViewById<Chip>(R.id.drama_chip)
        val chipFamily = view.findViewById<Chip>(R.id.family_chip)
        val chipFantasy = view.findViewById<Chip>(R.id.fantasy_chip)
        val chipHorror = view.findViewById<Chip>(R.id.horror_chip)
        val chipMusical = view.findViewById<Chip>(R.id.musical_chip)
        val chipMystery = view.findViewById<Chip>(R.id.mystery_chip)
        val chipRomance = view.findViewById<Chip>(R.id.romance_chip)
        val chipSciFi = view.findViewById<Chip>(R.id.sci_fi_chip)
        val chipSport = view.findViewById<Chip>(R.id.sport_chip)
        val chipSuperhero = view.findViewById<Chip>(R.id.superhero_chip)
        val chipThriller = view.findViewById<Chip>(R.id.thriller_chip)
        val chipWar = view.findViewById<Chip>(R.id.war_chip)
        val chipWestern = view.findViewById<Chip>(R.id.western_chip)

        if(usersGenres != null){
            if("ACTION" in usersGenres) chipAction.isChecked = true
            if("ADVENTURE" in usersGenres) chipAdventure.isChecked = true
            if("ANIMATION" in usersGenres) chipAnimation.isChecked = true
            if("BIOGRAPHY" in usersGenres) chipBiography.isChecked = true
            if("COMEDY" in usersGenres) chipComedy.isChecked = true
            if("CRIME" in usersGenres) chipCrime.isChecked = true
            if("DOCUMENTARY" in usersGenres) chipDocumentary.isChecked = true
            if("DRAMA" in usersGenres) chipDrama.isChecked = true
            if("FAMILY" in usersGenres) chipFamily.isChecked = true
            if("FANTASY" in usersGenres) chipFantasy.isChecked = true
            if("HORROR" in usersGenres) chipHorror.isChecked = true
            if("MUSICAL" in usersGenres) chipMusical.isChecked = true
            if("MYSTERY" in usersGenres) chipMystery.isChecked = true
            if("ROMANCE" in usersGenres) chipRomance.isChecked = true
            if("SCI_FI" in usersGenres) chipSciFi.isChecked = true
            if("SPORT" in usersGenres) chipSport.isChecked = true
            if("SUPERHERO" in usersGenres) chipSuperhero.isChecked = true
            if("THRILLER" in usersGenres) chipThriller.isChecked = true
            if("WAR" in usersGenres) chipWar.isChecked = true
            if("WESTERN" in usersGenres) chipWestern.isChecked = true
        }

        cancelButton.setOnClickListener{
            dismiss()
        }

        saveButton.setOnClickListener{
            val selectedGenres = mutableSetOf<Genre>().apply {
                if (chipAction.isChecked) add(Genre.ACTION)
                if (chipAdventure.isChecked) add(Genre.ADVENTURE)
                if (chipAnimation.isChecked) add(Genre.ANIMATION)
                if (chipBiography.isChecked) add(Genre.BIOGRAPHY)
                if (chipComedy.isChecked) add(Genre.COMEDY)
                if (chipCrime.isChecked) add(Genre.CRIME)
                if (chipDocumentary.isChecked) add(Genre.DOCUMENTARY)
                if (chipDrama.isChecked) add(Genre.DRAMA)
                if (chipFamily.isChecked) add(Genre.FAMILY)
                if (chipFantasy.isChecked) add(Genre.FANTASY)
                if (chipHorror.isChecked) add(Genre.HORROR)
                if (chipMusical.isChecked) add(Genre.MUSICAL)
                if (chipMystery.isChecked) add(Genre.MYSTERY)
                if (chipRomance.isChecked) add(Genre.ROMANCE)
                if (chipSciFi.isChecked) add(Genre.SCI_FI)
                if (chipSport.isChecked) add(Genre.SPORT)
                if (chipSuperhero.isChecked) add(Genre.SUPERHERO)
                if (chipThriller.isChecked) add(Genre.THRILLER)
                if (chipWar.isChecked) add(Genre.WAR)
                if (chipWestern.isChecked) add(Genre.WESTERN)
            }
            onGenresSelectedListener?.onGenresSelected(selectedGenres)
            dismiss()
        }
        return view
    }

    fun setOnGenreSelectedListener(listener: OnGenresSelectedListener) {
         onGenresSelectedListener = listener
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}