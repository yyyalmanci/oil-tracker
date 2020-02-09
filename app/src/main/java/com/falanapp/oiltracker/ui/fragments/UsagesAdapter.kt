package com.example.deneme.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.falanapp.oiltracker.R
import com.falanapp.oiltracker.database.Usage
import com.falanapp.oiltracker.ui.fragments.DetailFragment
import com.falanapp.oiltracker.ui.fragments.ListFragment
import com.falanapp.oiltracker.ui.fragments.ListFragmentDirections
import com.falanapp.oiltracker.ui.fragments.NewUsageFragment


class UsagesAdapter(private val navController: NavController) :
    ListAdapter<Usage, UsagesAdapter.ViewHolder>(SleepNightDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.t1.text = item.deneme
        holder.t2.text = item.deneme2
        holder.itemView.setOnClickListener {
            navController.navigate(ListFragmentDirections.actionListFragmentToDetailFragment(item.usageId))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val t1: TextView = itemView.findViewById(R.id.textView)
        val t2: TextView = itemView.findViewById(R.id.textView2)

    }

}

class SleepNightDiffCallback : DiffUtil.ItemCallback<Usage>() {
    override fun areItemsTheSame(oldItem: Usage, newItem: Usage): Boolean {
        return oldItem.usageId == newItem.usageId
    }

    override fun areContentsTheSame(oldItem: Usage, newItem: Usage): Boolean {
        return oldItem == newItem
    }
}



