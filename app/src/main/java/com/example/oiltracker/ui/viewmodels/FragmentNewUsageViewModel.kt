package com.example.oiltracker.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oiltracker.database.Usage
import com.example.oiltracker.database.UsageDao
import kotlinx.coroutines.*
import java.lang.Appendable

class FragmentNewUsageViewModel(val database: UsageDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val usages = database.getAllUsages()

    fun insertUsage(id:Int,deneme: String,deneme2: String){
        uiScope.launch {
            val newUsage = Usage(id,deneme, deneme2)
            insert(newUsage)
        }

    }

    private suspend fun  insert(usage: Usage){
        withContext(Dispatchers.IO){
            database.insert(usage)
        }
    }

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


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}