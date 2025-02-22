package com.example.mycityapp.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycityapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState, scope: CoroutineScope) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.menu),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            ,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(R.string.main),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 10.dp,
                    horizontal = 10.dp
                )
                .clickable {
                    scope.launch { drawerState.close() }
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = false }
                    }
                }
        )

        listOf(1, 2, 3).forEach{ it ->
            Text(
                text = stringResource(
                    when(it){
                        1 -> R.string.restaurants
                        2 -> R.string.universities
                        3 -> R.string.gyms
                        else -> R.string.empty
                    }
                ),
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 10.dp,
                        horizontal = 10.dp
                    )
                    .clickable {
                        scope.launch { drawerState.close() }
                        navController.navigate("category/$it") {
                            popUpTo("home") { inclusive = false }
                        }
                    }
            )
        }
    }
}