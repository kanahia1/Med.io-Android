package com.kanahia.demo.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.View
import android.widget.Toast
import com.kanahia.demo.Fragments.CalendarFragment
import com.kanahia.demo.Fragments.Chat
import com.kanahia.demo.Fragments.HomeFragment
import com.kanahia.demo.Fragments.ProfileFragment
import com.kanahia.demo.R
import com.kanahia.demo.bottomify.BottomifyNavigationView
import com.kanahia.demo.bottomify.OnNavigationItemChangeListener
import com.kanahia.demo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    val intialFragment = 2 // Just for dev purposes

    val chatFragment = Chat()
    val homeFragment = HomeFragment()
    val calendarFragment = CalendarFragment()
    val profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSupportActionBar()?.hide()
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        val bottomify = findViewById<BottomifyNavigationView>(R.id.bottomify_nav)

        if (savedInstanceState == null) {
            changeFragment(intialFragment)
        }
        bottomify.setActiveNavigationIndex(intialFragment)


        bottomify.setOnNavigationItemChangedListener(object : OnNavigationItemChangeListener {
            override fun onNavigationItemChanged(navigationItem: BottomifyNavigationView.NavigationItem) {
                changeFragment(navigationItem.position)
            }
        })


    }

    fun changeFragment(index : Int ){

        when(index){
            0 ->  supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view,homeFragment)
                commit()
            }
            1 ->  supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view,calendarFragment)
                commit()
            }
            2 ->  supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view,chatFragment)
                commit()
            }
            3 -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view,profileFragment)
                commit()
            }
            else ->  supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view,homeFragment)
                commit()
            }

        }


    }

}