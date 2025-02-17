package com.example.thobile_intermediateassessementtodo.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thobile_intermediateassessementtodo.data.DataOrException
import com.example.thobile_intermediateassessementtodo.model.WeatherObject
import com.example.thobile_intermediateassessementtodo.repo.TaskRepository
import com.example.thobile_intermediateassessementtodo.repo.WeatherRepo
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WeatherRepo) : ViewModel() {

 suspend fun getWeatherData(city:String):DataOrException<WeatherObject,Boolean,Exception>{
     return repository.getWeather("Springs")
 }

}