package com.example.mycityapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.models.Category
import com.example.mycityapp.data.repository.PlaceRepository

class CategoryViewModel(private val repository: PlaceRepository = PlaceRepository()): ViewModel(){
    fun getPlaces(categoryId: Int): Category = repository.getCategoryById(categoryId)
}