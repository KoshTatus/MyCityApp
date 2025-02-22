package com.example.mycityapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycityapp.R
import com.example.mycityapp.data.models.Place
import com.example.mycityapp.ui.viewmodels.CategoryViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CategoryScreen(
    navController: NavHostController,
    categoryId: Int,
    viewModel: CategoryViewModel = CategoryViewModel()
) {
    val places = remember { mutableStateOf(viewModel.getPlaces(categoryId)) }

    Scaffold() { padding ->
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
            Text(
                text = places.value.name,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(vertical = 50.dp)
        ) {
            items(places.value.places) { place ->
                PlaceItem(place = place) { selectedPlace ->
                    navController.navigate("detail/${selectedPlace.id}")
                }
            }
        }
    }
}

@Composable
fun PlaceItem(place: Place, onClick: (Place) -> Unit){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { onClick(place) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)){
            Image(
                painter = painterResource(id = place.imageId),
                contentDescription = place.name,
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp)) {
                Text(text = place.name, style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}