package com.example.kinogid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch

class DetailListFragment: Fragment(), MovieSelectorDialogFragment.OnMoviesSelectedListener {
    lateinit var viewModel: MainViewModel
    lateinit var titleTextView: TextView
    lateinit var descriptionTextView: TextView
    lateinit var selectMoviesButton: Button
    lateinit var footer: TextView
    var moviesId = mutableSetOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_detail_list, container, false)
        titleTextView = view.findViewById(R.id.list_title)
        descriptionTextView = view.findViewById(R.id.description)
        selectMoviesButton = view.findViewById(R.id.add_movies_btn)
        footer = view.findViewById(R.id.footer)

        titleTextView.setOnClickListener {
            showEditDialog(titleTextView, 1)
        }

        descriptionTextView.setOnClickListener {
            showEditDialog(descriptionTextView, 2)
        }

        selectMoviesButton.setOnClickListener {
            val dialogFragment = MovieSelectorDialogFragment()
            dialogFragment.onMoviesSelectedListener = this
            dialogFragment.show(parentFragmentManager, "MovieSelector")
        }

        footer.setOnClickListener {
            lifecycleScope.launch {
                viewModel.createNewListOfMovies(
                    titleTextView.text.toString(),
                    moviesId.joinToString(","),
                    descriptionTextView.text.toString()
                )
                findNavController().popBackStack()
            }
        }

        return view
    }

    //type==1 => название; type==2 => описание
    private fun showEditDialog(textView: TextView, type: Int) {
        val inputField = EditText(requireContext())

        if (type == 1){
            AlertDialog.Builder(requireContext(), R.style.DialogTheme)
                .setTitle("Изменение названия списка")
                .setView(inputField)
                .setPositiveButton("Сохранить") { _, _ ->
                    val newText = inputField.text.toString().replace("\n", "")
                    if (newText.isNotBlank()) textView.text = newText
                }
                .setNegativeButton("Отмена", null)
                .show()
        }

        if (type == 2){
            inputField.setText(textView.text)
            AlertDialog.Builder(requireContext(), R.style.DialogTheme)
                .setTitle("Изменение описания списка")
                .setView(inputField)
                .setPositiveButton("Сохранить") { _, _ ->
                    var newText = inputField.text.toString()/*.replace("\n\n\n", "\n\n") просто так
                    не пойдет, поскольку если будет 7 подряд \n, то он уберет только 3, а не все 6 нужных*/
                    while ("\n\n\n" in newText) newText = newText.replace("\n\n\n", "\n\n")
                    while (newText.last() == '\n') newText = newText.dropLast(1)
                    if (newText.isNotBlank()) textView.text = newText
                }
                .setNegativeButton("Отмена", null)
                .show()
        }
    }

    override fun onMoviesSelected(selectedMoviesId: Set<Int>) {
        moviesId = selectedMoviesId.toMutableSet()
//        Log.d("MovieSelect", moviesId.toString())
    }
}