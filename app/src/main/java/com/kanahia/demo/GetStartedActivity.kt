package com.kanahia.demo

import android.content.Intent
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

    private lateinit var b : ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(b.root)

        getSupportActionBar()?.hide()
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        b.signinBtn.applyClickShrink()


        b.signinBtn.setOnClickListener {
            val i = Intent(
                this@GetStartedActivity,
                SignInActivity::class.java
            )
            startActivity(i)
        }
    }
}