package com.akshay.ourweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.akshay.ourweatherapp.ui.theme.OurWeatherAppTheme
import com.akshay.ourweatherapp.ui.view.WeatherPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        setContent {
            OurWeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    WeatherPage(weatherViewModel)

                }
                }
            }
        }
    }

