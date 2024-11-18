package com.akshay.ourweatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.ourweatherapp.api.Constant
import com.akshay.ourweatherapp.api.NetworkResponse
import com.akshay.ourweatherapp.api.RetrofitInstance
import com.akshay.ourweatherapp.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel :ViewModel(){

    private val weatherApi =RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
     val weatherResult : LiveData<NetworkResponse<WeatherModel>> = _weatherResult

    fun getWeatherData(city:String){
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
           try {
               val response = weatherApi.getWeather(Constant.apiKey,city)
               if(response.isSuccessful){
                   response.body()?.let{
                       _weatherResult.value = NetworkResponse.Success(it)
                   }

               }else{
                   _weatherResult.value = NetworkResponse.Error("Error Loading $city Weather Details")

               }
           }
           catch (e:Exception){
               _weatherResult.value = NetworkResponse.Error("Error Loading $city Weather Details")

           }
        }

    }
}