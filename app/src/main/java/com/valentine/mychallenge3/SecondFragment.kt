package com.valentine.mychallenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

//global:agar bisa dipakai kembali difragment 4
lateinit var name:String

class SecondFragment : Fragment() {
    private lateinit var ThirdFragmentButton: Button
    private lateinit var edtName: EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //casting data
        ThirdFragmentButton = view.findViewById(R.id.button)
        edtName = view.findViewById(R.id.edt_name)
        ThirdFragmentButton.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            name = edtName.text.toString().trim()
            val bundle =  Bundle()
            bundle.putString("name_key", name)
            thirdFragment.arguments = bundle

            //object instance fragment
            fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, thirdFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}