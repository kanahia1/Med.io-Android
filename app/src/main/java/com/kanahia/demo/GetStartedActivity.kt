package com.kanahia.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.kanahia.demo.ViewModel.MainViewModel
import com.kanahia.demo.ViewModel.MainViewModelFactory
import com.kanahia.demo.api.ApiRepository
import com.kanahia.demo.api.ApiService
import com.kanahia.demo.api.RetrofitHelper
import com.kanahia.demo.databinding.ActivityGetStartedBinding
import com.realpacific.clickshrinkeffect.applyClickShrink

class GetStartedActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private lateinit var b : ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(b.root)

        getSupportActionBar()?.hide()
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        b.signinBtn.applyClickShrink()

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