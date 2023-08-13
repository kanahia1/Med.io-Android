package com.kanahia.demo.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.kanahia.demo.api.ApiRepository
import com.kanahia.demo.models.Dema

class MainViewModelFactory(private val repository: ApiRepository,private val d:Dema) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, d ) as T
    }


}