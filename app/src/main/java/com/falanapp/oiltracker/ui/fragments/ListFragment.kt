package com.falanapp.oiltracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.falanapp.oiltracker.R
import com.falanapp.oiltracker.ui.viewmodels.FragmentListViewModel
import com.falanapp.oiltracker.ui.viewmodels.FragmentListViewModelFactory

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_fragment, container, false)

        val button: Button = view.findViewById(R.id.button)
        val editText: EditText = view.findViewById(R.id.editText)
        val textView: TextView = view.findViewById(R.id.viewModel)

        val viewModelFactory = FragmentListViewModelFactory()
        val fragmentListViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(FragmentListViewModel::class.java)

        return view

    }
}