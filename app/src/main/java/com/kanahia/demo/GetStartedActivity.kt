package com.kanahia.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.kanahia.demo.ViewModel.MainViewModel
import com.kanahia.demo.ViewModel.MainViewModelFactory
import com.kanahia.demo.api.ApiRepository
import com.kanahia.demo.api.ApiService
import com.kanahia.demo.api.RetrofitHelper

class GetStartedActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repository = ApiRepository(apiService)
        mainViewModel = ViewModelProvider(this,
            MainViewModelFactory(repository)
        ).get(MainViewModel::class.java)


        mainViewModel.data.observe(this){
            Log.e("PRINT",it.toString())

        }
    }
}