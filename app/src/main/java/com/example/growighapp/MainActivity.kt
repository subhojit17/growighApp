package com.example.growighapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var skipbutton: Button
    companion object {
        const val PREFS_NAME= "MyPreference"
        const val KEY= "MyPreference"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedpref : SharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val isFirstTime = sharedpref.getBoolean(KEY,true)
        if(isFirstTime) showOnboardingScreen()
        else{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }

    private fun showOnboardingScreen(){
        viewPager = findViewById(R.id.viewpager)
        val pagerAdapter = FragmentPagerAdapter(this)
        viewPager.adapter = pagerAdapter
        skipbutton= findViewById(R.id.skip_button)
        skipbutton.setOnClickListener {
            val sharedpref : SharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
            sharedpref.edit().putBoolean(KEY,false).apply()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}