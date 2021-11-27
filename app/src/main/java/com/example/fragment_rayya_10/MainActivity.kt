package com.example.fragment_rayya_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_rayya_10.fragment.HomeFragment
import com.example.fragment_rayya_10.fragment.NotificationFragment
import com.example.fragment_rayya_10.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notoficationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.button_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(notoficationFragment)
                R.id.menu_settings -> makeCurrentFragment(settingsFragment)
            }

            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }

    }
}