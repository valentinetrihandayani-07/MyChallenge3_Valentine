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

class FourFragment : Fragment() {
    private lateinit var ThirdFragmentButton: Button
    private lateinit var edtUsia: EditText
    private lateinit var edtAlamat: EditText
    private lateinit var edtPekerjaan: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //casting data
        ThirdFragmentButton = view.findViewById(R.id.button)
        edtUsia = view.findViewById(R.id.edt_usia)
        edtAlamat = view.findViewById(R.id.edt_alamat)
        edtPekerjaan = view.findViewById(R.id.edt_pekerjaan)

        //button clik
        ThirdFragmentButton.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val fragmentManager:FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            //passing data ambil inputan ditampung kedalam variabel
            val usia = edtUsia.text.toString().trim()
            val alamat = edtAlamat.text.toString().trim()
            val pekerjaan = edtPekerjaan.text.toString().trim()

            val bundle = Bundle()
            //parcelize
            val atribute = Atribute (
                //data dinamis
                name = name,
                usia = usia.toInt(),
                alamat = alamat,
                pekerjaan = pekerjaan
                    )
            //untuk mengirim data menggunakan key
            bundle.putParcelable("name_key4", atribute)
            thirdFragment.arguments = bundle
            fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, thirdFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }


}