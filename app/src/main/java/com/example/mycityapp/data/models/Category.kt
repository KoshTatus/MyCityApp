package com.example.mycityapp.data.models

data class Category(
    val id: Int,
    val name: String,
    val places: List<Place>
)