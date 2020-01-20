package com.falanapp.oiltracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.falanapp.oiltracker.R
import com.falanapp.oiltracker.database.UsageDatabase

class DetailFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = UsageDatabase.getInstance(application).UsageDao


        return view
    }

}