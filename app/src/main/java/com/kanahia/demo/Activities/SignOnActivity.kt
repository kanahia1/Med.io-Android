package com.kanahia.demo.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kanahia.demo.databinding.ActivitySignOnBinding
import com.realpacific.clickshrinkeffect.applyClickShrink

class SignOnActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignOnBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySignOnBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        getSupportActionBar()?.hide()
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        binding.signInButton.applyClickShrink()

        binding.signInButton.setOnClick{
            startActivity(Intent(this@SignOnActivity,HomeActivity::class.java))
        }
    }
}