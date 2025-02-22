package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.mycityapp.ui.App
import com.example.mycityapp.ui.theme.MyCityAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    App()
                }
            }
        }
    }
}
