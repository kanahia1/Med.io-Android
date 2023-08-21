package com.kanahia.demo.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                SignOnActivity::class.java
            )
            startActivity(i)
        }
    }
}