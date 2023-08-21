package com.kanahia.demo.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            binding.userText.text = binding.aiEditText.text.toString()
            var dema = Dema(array)

            var mainViewModel: MainViewModel = ViewModelProvider(this,
                MainViewModelFactory(repository,dema)
            ).get(MainViewModel::class.java)

            mainViewModel.data.observe(this){
                var list = it.data
                binding.diseases.visibility = View.VISIBLE
                var pro1 = list[0].confidences[0].confidence?.times(100)
                var text1 = list[0].confidences[0].label

                binding.disease1Per.text = pro1.toString()
                binding.disease1Progress.setProgress(pro1!!.toInt())
                binding.disease1Text.text = text1

                var pro2 = list[0].confidences[1].confidence?.times(100)
                var text2 = list[0].confidences[1].label

                binding.disease2Per.text = pro2.toString()
                binding.disease2Progress.setProgress(pro2!!.toInt())
                binding.disease2Text.text = text2

                var pro3 = list[0].confidences[2].confidence?.times(100)
                var text3 = list[0].confidences[2].label

                binding.disease3Per.text = pro3.toString()
                binding.disease3Progress.setProgress(pro3!!.toInt())
                binding.disease3Text.text = text3

                var pro4 = list[0].confidences[3].confidence?.times(100)
                var text4 = list[0].confidences[3].label

                binding.disease4Per.text = pro4.toString()
                binding.disease4Progress.setProgress(pro4!!.toInt())
                binding.disease4Text.text = text4


            }
        }






    }
}