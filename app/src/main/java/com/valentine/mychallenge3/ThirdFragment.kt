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

class ThirdFragment : Fragment() {
    //deklarasi dari fragment 2
    lateinit var nameTextView: TextView
    lateinit var FourFragmentButton: Button
    //deklarasi dari fragment 4
    lateinit var nameTextView2: TextView
    lateinit var usiaTextView: TextView
    lateinit var alamatTextView: TextView
    lateinit var pekerjaanTextView: TextView
    lateinit var detail: ConstraintLayout
    //deklarasi xml fragment detail
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
        //casting fragment 2
        nameTextView = view.findViewById(R.id.txt_yourname)
        //casting fragment 4
        nameTextView2 = view.findViewById(R.id.txt_fullname)
        usiaTextView = view.findViewById(R.id.txt_age)
        alamatTextView = view.findViewById(R.id.txt_alamat)
        pekerjaanTextView = view.findViewById(R.id.txt_pekerjaan)
        detail = view.findViewById(R.id.view_detail_4)
        //detail fragment


        //ambil data yang telah dikirim dari fragment 2 kedalam variabel
        val name = arguments?.getString("name_key")
        //ambil data yang telah dikirim dari fragment 4
        val atribute = arguments?.getParcelable<Atribute>("name_key4")


        //show fragment 2
        nameTextView.text = name
        //show fragment 4
    if (atribute!=null){
        nameTextView.visibility= View.INVISIBLE
        detail.visibility = View.VISIBLE

        nameTextView2.text = atribute.name
        alamatTextView.text = atribute.alamat
        pekerjaanTextView.text = atribute.pekerjaan

        if (atribute.usia % 2 == 0) {
            status = "Genap"
            usia = getString(R.string.umur, atribute.usia, status)

        } else {
            status = "Ganjil"
            usia = getString(R.string.umur, atribute.usia, status)
        }
        usiaTextView.text = usia
    }



        //casting data
        FourFragmentButton = view.findViewById(R.id.btn_screen_3)

        FourFragmentButton.setOnClickListener {
            val fourFragment = FourFragment()
            val fragmentManager:FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            //object instance fragment
            fragmentTransaction.replace(R.id.frame_layout_container, fourFragment, FourFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }
}