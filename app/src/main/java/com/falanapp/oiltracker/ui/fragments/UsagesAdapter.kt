package com.example.deneme.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.falanapp.oiltracker.R
import com.falanapp.oiltracker.database.Usage


class UsagesAdapter(val clickListener: UsageListener) :
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
            clickListener.onClick(item)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val t1: TextView = itemView.findViewById(R.id.textView)
        val t2: TextView = itemView.findViewById(R.id.textView2)

    }

}

class UsageListener(val clickListener: (usageId: Int) -> Unit) {
    fun onClick(usage: Usage) = clickListener(usage.usageId)
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<Usage>() {
    override fun areItemsTheSame(oldItem: Usage, newItem: Usage): Boolean {
        return oldItem.usageId == newItem.usageId
    }

    override fun areContentsTheSame(oldItem: Usage, newItem: Usage): Boolean {
        return oldItem == newItem
    }
}



