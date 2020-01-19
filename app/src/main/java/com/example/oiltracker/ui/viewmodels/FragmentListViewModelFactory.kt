package com.example.oiltracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FragmentListViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FragmentListViewModel::class.java)) {
            return FragmentListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}