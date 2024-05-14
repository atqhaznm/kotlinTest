package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
        handleFAB()

        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setTitle("My Contacts")
    }

    private fun setupBottomNavigation() {
        val botNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

       botNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_contact -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

       botNav.selectedItemId = R.id.nav_contact
    }

    private fun handleFAB() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
          loadFragment(NewContactFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}