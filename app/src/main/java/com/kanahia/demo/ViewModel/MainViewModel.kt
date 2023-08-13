package com.kanahia.demo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanahia.demo.Datam
import com.kanahia.demo.api.ApiRepository
import com.kanahia.demo.models.Data
import com.kanahia.demo.models.Dema
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: ApiRepository,val d : Dema) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.postRequest(d)
        }

    }

    val data : LiveData<Datam>
    get() = repository.data
}