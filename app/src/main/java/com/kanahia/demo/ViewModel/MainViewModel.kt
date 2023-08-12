package com.kanahia.demo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanahia.demo.api.ApiRepository
import com.kanahia.demo.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: ApiRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getRequest()
        }

    }

    val data : LiveData<Data>
    get() = repository.data
}