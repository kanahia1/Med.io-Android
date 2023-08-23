package com.kanahia.demo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kanahia.demo.R
import com.kanahia.demo.ViewModel.MainViewModel
import com.kanahia.demo.ViewModel.MainViewModelFactory
import com.kanahia.demo.api.ApiRepository
import com.kanahia.demo.api.ApiService
import com.kanahia.demo.api.RetrofitHelper
import com.kanahia.demo.databinding.FragmentChatBinding
import com.kanahia.demo.models.Dema

class Chat : Fragment(R.layout.fragment_chat){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentChatBinding = FragmentChatBinding.inflate(inflater, container, false)



        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repository = ApiRepository(apiService)

        binding.smtBtn?.setOnClickListener {

            var array = arrayListOf<String>()
            array.add("str")
            array.add(binding.aIEditText.text.toString())
            //binding.userText.text = binding.aiEditText.text.toString()
            var dema = Dema(array)

            var mainViewModel: MainViewModel = ViewModelProvider(
                this,
                MainViewModelFactory(repository, dema)
            ).get(MainViewModel::class.java)

            mainViewModel.data.observe(viewLifecycleOwner) {
                var list = it.data
                binding.diseases!!.visibility = View.VISIBLE

                var pro1 = String.format("%.2f", list[0].confidences[0].confidence?.times(100)).toDouble()
                var text1 = list[0].confidences[0].label

                binding.diseaseAI1Per!!.text = pro1.toString() + "%"
                binding.diseaseAI1Progress!!.setProgress(pro1!!.toInt())
                binding.diseaseAI1Text!!.text = text1


                var pro2 = String.format("%.2f", list[0].confidences[1].confidence?.times(100)).toDouble()
                var text2 = list[0].confidences[1].label

                binding.diseaseAI2Per!!.text = pro2.toString() + "%"
                binding.diseaseAI2Progress!!.setProgress(pro2!!.toInt())
                binding.diseaseAI2Text!!.text = text2

                var pro3 = String.format("%.2f",list[0].confidences[2].confidence?.times(100)).toDouble()
                var text3 = list[0].confidences[2].label

                binding.diseaseAI3Per!!.text = pro3.toString() + "%"
                binding.diseaseAI3Progress!!.setProgress(pro3!!.toInt())
                binding.diseaseAI3Text!!.text = text3

                var pro4 = String.format("%.2f",list[0].confidences[3].confidence?.times(100)).toDouble()
                var text4 = list[0].confidences[3].label

                binding.diseaseAI4Per!!.text = pro4.toString() + "%"
                binding.diseaseAI4Progress!!.setProgress(pro4!!.toInt())
                binding.diseaseAI4Text!!.text = text4


            }
        }
        return binding.root

    }

}

