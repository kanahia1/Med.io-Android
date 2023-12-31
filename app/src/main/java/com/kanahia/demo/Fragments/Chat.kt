package com.kanahia.demo.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
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
import okhttp3.internal.notify

class Chat : Fragment(R.layout.fragment_chat){
    private lateinit var binding: FragmentChatBinding
    val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
    val repository = ApiRepository(apiService)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatBinding.inflate(inflater, container, false)

        binding.smtBtn?.setOnClickListener {
            click()
        }

        binding.aIEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
               click()
            }
            true
        }
        return binding.root

    }

    private fun click(){

        hideKeyboard(binding.root)

        binding.diseases!!.visibility = View.GONE
        binding.diseasesText!!.visibility = View.GONE

        binding.userIV!!.visibility = View.VISIBLE
        binding.userInputC!!.visibility = View.VISIBLE
        binding.userInputTV!!.text = binding.aIEditText!!.text

        binding.loadingChat!!.visibility = View.VISIBLE

        var array = arrayListOf<String>()

        array.add(binding.aIEditText.text.toString())
        //binding.userText.text = binding.aiEditText.text.toString()
        var dema = Dema(array)

        var mainViewModel: MainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository, dema)
        ).get(MainViewModel::class.java)
        mainViewModel.getData()
        //  mainViewModel.notify()

        mainViewModel.data.observe(viewLifecycleOwner) {
            var list = it.data
            binding.loadingChat!!.visibility = View.GONE
            binding.diseases!!.visibility = View.VISIBLE
            binding.diseasesText!!.visibility = View.VISIBLE

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

        binding.aIEditText.setText("")
    }
    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }




}

