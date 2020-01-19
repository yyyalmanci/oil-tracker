package com.example.oiltracker.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.oiltracker.R
import com.example.oiltracker.database.UsageDatabase
import com.example.oiltracker.ui.viewmodels.FragmentNewUsageViewModel
import com.example.oiltracker.ui.viewmodels.FragmentNewUsageViewModelFactory


class NewUsageFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_new_usage,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = UsageDatabase.getInstance(application).UsageDao
        val viewModelFactory = FragmentNewUsageViewModelFactory(dataSource,application)
        val fragmentNewUsageViewModel = ViewModelProviders.of(this, viewModelFactory).get(
            FragmentNewUsageViewModel::class.java
        )

        val button :Button = view.findViewById(R.id.add_btn)
        val editText :EditText = view.findViewById(R.id.t1)
        val editText2 :EditText = view.findViewById(R.id.t2)

        button.setOnClickListener {
            fragmentNewUsageViewModel.insertUsage(0,editText.text.toString(),editText2.text.toString())
        }

        return view

    }

}