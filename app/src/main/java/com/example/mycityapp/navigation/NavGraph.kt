package com.example.mycityapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycityapp.ui.screens.CategoryScreen
import com.example.mycityapp.ui.screens.DetailScreen
import com.example.mycityapp.ui.screens.HomeScreen

@Composable
fun NavHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController = navController)
        }
        composable("category/{categoryId}"){ backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull() ?: 1
            CategoryScreen(navController = navController, categoryId = categoryId)
        }
        composable("detail/{placeId}"){ backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")?.toIntOrNull() ?: 1
            DetailScreen(placeId = placeId, navController = navController)
        }
    }
}