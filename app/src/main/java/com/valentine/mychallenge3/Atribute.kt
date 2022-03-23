package com.valentine.mychallenge3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Atribute(
    val name: String,
    val usia: Int,
    val alamat: String,
    val pekerjaan: String
): Parcelable
