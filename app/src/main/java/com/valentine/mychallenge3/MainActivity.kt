package com.valentine.mychallenge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFirstFragment()
    }
    //memasukkan sebuah fragment kedalam activity
    private fun openFirstFragment(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        //object instance fragment
        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.frame_layout_container,firstFragment, FirstFragment::class.java.simpleName)
        fragmentTransaction.commit()
    }
}