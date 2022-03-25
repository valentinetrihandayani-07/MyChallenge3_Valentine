package com.valentine.mychallenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Constraints
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ThirdFragment : Fragment() {
    private val arguments: ThirdFragmentArgs by navArgs()
    private var status = ""
    private var usia = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //casting data
        val button = view.findViewById<Button>(R.id.btn_screen_3)
        val usernameTextView4 = view.findViewById<TextView>(R.id.txt_fullname)
        val ageTextView = view.findViewById<TextView>(R.id.txt_age)
        val alamatTextView = view.findViewById<TextView>(R.id.txt_alamat)
        val pekerjaanTextView = view.findViewById<TextView>(R.id.txt_pekerjaan)


        //get fragment 2
        usernameTextView4.text = arguments.parcelableData?.name
        //get fragment 4
        ageTextView.text = arguments.parcelableData?.usia.toString()
        alamatTextView.text = arguments.parcelableData?.alamat.toString()
        pekerjaanTextView.text = arguments.parcelableData?.pekerjaan.toString()
        //parcelable data
        val atribute = arguments.parcelableData
        //show fragment 2
        usernameTextView4.text = atribute?.name
        //show fragment 4
        if (atribute?.pekerjaan != null && atribute.alamat != null && atribute.usia != null) {

            //menampilkan nama jika terisi namun jika tidak maka tersembunyi
            alamatTextView.visibility = View.VISIBLE
            pekerjaanTextView.visibility = View.VISIBLE
            ageTextView.visibility = View.VISIBLE

            alamatTextView.text = atribute.alamat
            pekerjaanTextView.text = atribute.pekerjaan
            //memeriksa usia ganjil dan genap
            atribute.usia?.let {
                if (it % 2 == 0) {
                    status = "Genap"
                    usia = getString(R.string.umur, atribute.usia, status)

                } else {
                    status = "Ganjil"
                    usia = getString(R.string.umur, atribute.usia, status)
                }
                ageTextView.text = usia

            }

        }

        button.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_fourFragment)
        }
    }


}