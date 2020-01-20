package com.falanapp.oiltracker.ui.fragments

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
import androidx.recyclerview.widget.RecyclerView
import com.example.deneme.ui.fragments.UsageListener
import com.example.deneme.ui.fragments.UsagesAdapter
import com.falanapp.oiltracker.R
import com.falanapp.oiltracker.database.UsageDatabase
import com.falanapp.oiltracker.ui.viewmodels.FragmentListViewModel
import com.falanapp.oiltracker.ui.viewmodels.FragmentListViewModelFactory

class ListFragment : Fragment() {
    lateinit var btnDelete: Button
    lateinit var title: TextView
    lateinit var btnAdd: Button
    lateinit var list: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = UsageDatabase.getInstance(application).UsageDao
        val viewModelFactory = FragmentListViewModelFactory(dataSource, application)
        val fragmentListViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(FragmentListViewModel::class.java)

        bindViews(view)

        val adapter = UsagesAdapter(UsageListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(it))
        })

        list.adapter = adapter

        fragmentListViewModel.usages.observe(this, Observer {
            adapter.submitList(it)
        })

        setOnClickListeners(fragmentListViewModel)


        return view

    }

    fun bindViews(view :View) {

        btnDelete = view.findViewById(R.id.delete_btn)
        btnAdd = view.findViewById(R.id.new_usage)
        title = view.findViewById(R.id.title)
        list = view.findViewById(R.id.usage_list)

    }

    fun setOnClickListeners(viewModel: FragmentListViewModel){
        btnDelete.setOnClickListener {
            viewModel.onClear()
        }
        btnAdd.setOnClickListener {
         findNavController().navigate(ListFragmentDirections.actionListFragmentToNewUsageFragment())
        }
    }
}