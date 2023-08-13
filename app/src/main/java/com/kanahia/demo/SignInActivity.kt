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
import com.kanahia.demo.databinding.ActivitySignInBinding
import com.kanahia.demo.models.Dema


class SignInActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getSupportActionBar()?.hide()
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)


        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repository = ApiRepository(apiService)

        binding.button.setOnClickListener {

            var array = arrayListOf<String>()
            array.add("str")
            array.add(binding.aiEditText.text.toString())
            var dema : Dema = Dema(array)

            mainViewModel = ViewModelProvider(this,
                MainViewModelFactory(repository,dema)
            ).get(MainViewModel::class.java)

            mainViewModel.data.observe(this){
                Log.e("PRINT",it.toString())

            }
        }






    }
}