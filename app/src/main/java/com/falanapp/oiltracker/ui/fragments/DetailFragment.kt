package com.falanapp.oiltracker.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deneme.ui.viewmodels.FragmentDetailViewModel
import com.example.deneme.ui.viewmodels.FragmentDetailViewModelFactory
import com.falanapp.oiltracker.R
import com.falanapp.oiltracker.database.UsageDatabase
import com.falanapp.oiltracker.ui.viewmodels.FragmentListViewModel
import com.falanapp.oiltracker.ui.viewmodels.FragmentListViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = UsageDatabase.getInstance(application).UsageDao
        val id = DetailFragmentArgs.fromBundle(requireArguments()).number
        val add :Button = view.findViewById(R.id.btn_update)


        val viewModelFactory = FragmentDetailViewModelFactory(id,dataSource, application)
        val fragmentDetailViewModel =
            ViewModelProvider(this, viewModelFactory).get(FragmentDetailViewModel::class.java)


        fragmentDetailViewModel.usage.observe(this, Observer {
            edit_deneme.setText(it.deneme)
            edit_deneme2.setText(it.deneme2)
        })

        add.setOnClickListener {
            fragmentDetailViewModel.updateUsage(edit_deneme.text.toString(),edit_deneme2.text.toString())
        }



        return view
    }

}