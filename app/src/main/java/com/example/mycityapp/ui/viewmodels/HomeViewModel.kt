package com.example.mycityapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.models.Category
import com.example.mycityapp.data.repository.PlaceRepository

class HomeViewModel(repository: PlaceRepository = PlaceRepository()): ViewModel(){
    val categories: List<Category> = repository.getCategories()
}