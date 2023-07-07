package com.example.growighapp

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class Screen3Fragment : Fragment() {

    private lateinit var progressButton: ImageView
    private lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_screen3, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpager)
        progressButton = view.findViewById(R.id.progress_button_page3)
        progressButton.setOnClickListener(View.OnClickListener {
            val sharedpref : SharedPreferences = requireActivity().getSharedPreferences(MainActivity.Companion.PREFS_NAME, MODE_PRIVATE)
            sharedpref.edit().putBoolean(MainActivity.Companion.KEY,false).apply()
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent) })
        return view
    }

}