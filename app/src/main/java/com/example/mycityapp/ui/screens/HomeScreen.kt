package com.example.mycityapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycityapp.R
import com.example.mycityapp.data.models.Category
import com.example.mycityapp.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = HomeViewModel()
){
    val categories =  viewModel.categories

    Column(modifier = Modifier.fillMaxSize()){
        Text(
            text = stringResource(R.string.category),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        LazyColumn {
            items(categories) { category ->
                CategoryItem(category = category){ categoryId ->
                    navController.navigate("category/$categoryId")
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category, onClick: (Int) -> Unit){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { onClick(category.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)){
            Text(text = category.name, style = MaterialTheme.typography.headlineSmall)
        }
    }
}