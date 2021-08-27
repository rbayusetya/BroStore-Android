package com.example.brostore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()

        setCurrentFragment(firstFragment)

        BottomNavigationView.OnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu->{
                    setCurrentFragment(firstFragment)
                }
                R.id.cart->{
                    setCurrentFragment(secondFragment)
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}

