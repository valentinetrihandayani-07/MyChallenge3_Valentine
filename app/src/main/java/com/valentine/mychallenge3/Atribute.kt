package com.valentine.mychallenge3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Atribute(
    val name: String,
    val usia: Int?=null,
    val alamat:String?=null,
    val pekerjaan: String?=null
): Parcelable
