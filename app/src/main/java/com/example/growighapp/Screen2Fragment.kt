package com.example.growighapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class Screen2Fragment : Fragment() {
    private lateinit var progressButton: ImageView
    private lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_screen2, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpager)
        progressButton = view.findViewById(R.id.progress_button_page2)
        progressButton.setOnClickListener(View.OnClickListener { viewPager.currentItem = 2 })
        return view    }

}