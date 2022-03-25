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

class FourFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button)

        val edtUsia = view.findViewById<EditText>(R.id.edt_usia)
        val edtAlamat = view.findViewById<EditText>(R.id.edt_alamat)
        val edtPekerjaan = view.findViewById<EditText>(R.id.edt_pekerjaan)

        button.setOnClickListener {
            //passing data

            val usia = edtUsia.text.toString().trim()
            val alamat = edtAlamat.text.toString().trim()
            val pekerjaan = edtPekerjaan.text.toString().trim()

            val data3 = Atribute(
                //data dinamis
                name = name,
                usia = usia.toInt(),
                alamat = alamat,
                pekerjaan = pekerjaan
            )
    findNavController().navigate(
                FourFragmentDirections.actionFourFragmentToThirdFragment(
                    data3
                )
            )

        }



    }
}