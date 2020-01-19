package com.example.oiltracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import com.example.oiltracker.R

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_fragment, container, false)

        val button: Button = view.findViewById(R.id.button)
        val editText: EditText = view.findViewById(R.id.editText)



        button.setOnClickListener {
            editText?.let {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment4(
                        editText.text.toString().toInt()
                    )
                )
            }
        }

        return view

    }
}