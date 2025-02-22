package com.example.mycityapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.models.Place
import com.example.mycityapp.data.repository.PlaceRepository

class DetailViewModel(private val repository: PlaceRepository = PlaceRepository()) : ViewModel() {
    fun getAllPlaces(): List<Place>{
        return repository.getCategories().flatMap { it.places}
    }
}