package com.example.oiltracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.oiltracker.R
import com.example.oiltracker.ui.viewmodels.FragmentListViewModel
import com.example.oiltracker.ui.viewmodels.FragmentListViewModelFactory
import com.example.oiltracker.ui.viewmodels.FragmentNewUsageViewModel
import com.example.oiltracker.ui.viewmodels.FragmentNewUsageViewModelFactory

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

        button.setOnClickListener {

            fragmentListViewModel.string.value = "furjan"

        }

        fragmentListViewModel.string.observe(this , Observer {

            textView.text = it
        })



        return view

    }
}