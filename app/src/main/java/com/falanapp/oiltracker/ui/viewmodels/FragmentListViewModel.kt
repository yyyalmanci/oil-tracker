package com.falanapp.oiltracker.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.falanapp.oiltracker.database.Usage
import com.falanapp.oiltracker.database.UsageDao
import kotlinx.coroutines.*

class FragmentListViewModel(val database: UsageDao, application: Application) : AndroidViewModel(application){

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val id = MutableLiveData<Int>()
    val usages = database.getAllUsages()



    fun onClear(){
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear(){
        withContext(Dispatchers.IO){
            database.clear()
        }
    }

}