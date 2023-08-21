package com.kanahia.demo.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kanahia.demo.R
import com.kanahia.demo.bottomify.BottomifyNavigationView
import com.kanahia.demo.bottomify.OnNavigationItemChangeListener
import com.kanahia.demo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSupportActionBar()?.hide()
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        val bottomify = findViewById<BottomifyNavigationView>(R.id.bottomify_nav)
        bottomify.setOnNavigationItemChangedListener(object : OnNavigationItemChangeListener {
            override fun onNavigationItemChanged(navigationItem: BottomifyNavigationView.NavigationItem) {
                Toast.makeText(this@HomeActivity,
                    "Selected item at index ${navigationItem.position}",
                    Toast.LENGTH_SHORT).show()
            }
        })


    }
}