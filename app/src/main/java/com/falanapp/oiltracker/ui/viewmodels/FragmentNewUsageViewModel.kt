package com.falanapp.oiltracker.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.falanapp.oiltracker.database.Usage
import com.falanapp.oiltracker.database.UsageDao
import kotlinx.coroutines.*

class FragmentNewUsageViewModel(val database: UsageDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}