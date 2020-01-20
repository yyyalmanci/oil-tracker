package com.example.deneme.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Update
import com.falanapp.oiltracker.database.Usage
import com.falanapp.oiltracker.database.UsageDao
import kotlinx.coroutines.*

class FragmentDetailViewModel(id: Int, val database: UsageDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val usage = MutableLiveData<Usage>()

    init {
        getDetail(id)

    }

    private fun getDetail(id: Int) {
        uiScope.launch {
            usage.value = getDetailFromDb(id)
        }
    }

    private suspend fun getDetailFromDb(id: Int): Usage? {
        return withContext(Dispatchers.IO) {
            val usage: Usage? = database.get(id)
            usage
        }
    }

//    fun updateUsage(id: Int, deneme: String, deneme2: String) {
//        uiScope.launch {
//            val usage = getDetailFromDb(id)
//            usage?.let {
//                usage.deneme = deneme
//                usage.deneme2 = deneme2
//                update(usage)
//            }
//
//        }
//    }

    fun updateUsage(deneme:String, deneme2:String){
        uiScope.launch {
            val usage = usage.value ?: return@launch
            usage.deneme = deneme
            usage.deneme2 = deneme2
            update(usage)
        }
    }

    private suspend fun update(usage: Usage) {
        withContext(Dispatchers.IO) {
            database.update(usage)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}