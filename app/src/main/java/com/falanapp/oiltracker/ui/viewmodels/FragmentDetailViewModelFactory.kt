package com.example.deneme.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.falanapp.oiltracker.database.UsageDao

class FragmentDetailViewModelFactory(
    private var id: Int,
    private val database: UsageDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FragmentDetailViewModel::class.java)) {
            return FragmentDetailViewModel(id, database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}