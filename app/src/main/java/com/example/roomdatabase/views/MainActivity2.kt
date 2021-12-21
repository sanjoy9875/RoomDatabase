package com.example.roomdatabase.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.roomdatabase.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fragmentManager = supportFragmentManager

        val fragmentTransaction = fragmentManager.beginTransaction()
        val mainFragment = MainFragment()
        fragmentTransaction.add(R.id.flContainer, mainFragment, "MainFragment")
            .commit()

    }
}