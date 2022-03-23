package com.valentine.mychallenge3

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class FirstFragment : Fragment() {
    private lateinit var SecondFragmentButton: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SecondFragmentButton = view.findViewById(R.id.btn_screen_1)
        SecondFragmentButton.setOnClickListener {
            val secondFragment = SecondFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(
                R.id.frame_layout_container,
                secondFragment,
                SecondFragmentButton::class.java.simpleName
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }


}