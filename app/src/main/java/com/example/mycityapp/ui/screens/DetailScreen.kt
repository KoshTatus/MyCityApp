package com.example.mycityapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycityapp.R
import com.example.mycityapp.ui.viewmodels.DetailViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    placeId: Int,
    navController: NavHostController,
    viewModel: DetailViewModel = DetailViewModel()
) {
    val place = remember { mutableStateOf(viewModel.getAllPlaces().find { it.id == placeId }) }

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back)
            )
        }
        Text(
            text = place.value?.name ?: "",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {
        item{
            Image(
                painter = painterResource(id = place.value?.imageId ?: R.drawable.empty),
                contentDescription = place.value?.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = place.value?.description ?: "",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = place.value?.address ?: "",
                style = MaterialTheme.typography.titleLarge,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(20.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}