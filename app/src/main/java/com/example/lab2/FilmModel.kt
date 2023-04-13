package com.example.lab2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmModel(val name: String, val year: Int, val image: Int, val about: String): Parcelable