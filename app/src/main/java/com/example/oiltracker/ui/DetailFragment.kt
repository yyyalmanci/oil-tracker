package com.example.oiltracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.oiltracker.R
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.detail_fragment,container,false)

        val textView: TextView = view.findViewById(R.id.text)

        val number = DetailFragmentArgs.fromBundle(arguments!!).number

        textView.text = number.toString()


        return view
    }

}