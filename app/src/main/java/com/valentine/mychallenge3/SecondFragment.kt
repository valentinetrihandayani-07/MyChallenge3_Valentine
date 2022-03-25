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
import androidx.navigation.fragment.findNavController

////global:agar bisa dipakai kembali difragment 4
lateinit var name:String
class SecondFragment : Fragment() {


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
        val button = view.findViewById<Button>(R.id.button)
        val edtName = view.findViewById<EditText>(R.id.edt_name)

        button.setOnClickListener {
            //send data
            name = edtName.text.toString().trim()

            val kirimdata = Atribute(name=name)
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(kirimdata))
        }
////    }



    }
}