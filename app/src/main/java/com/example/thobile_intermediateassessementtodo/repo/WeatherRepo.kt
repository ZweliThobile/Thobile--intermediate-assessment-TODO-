package com.example.thobile_intermediateassessementtodo.repo

import android.util.Log
import com.example.thobile_intermediateassessementtodo.data.DataOrException
import com.example.thobile_intermediateassessementtodo.model.WeatherObject
import com.example.thobile_intermediateassessementtodo.network.WeatherApi
import retrofit2.http.Query
import javax.inject.Inject

class WeatherRepo @Inject constructor(private val api: WeatherApi){

    suspend fun  getWeather(cityQuery: String): DataOrException<WeatherObject, Boolean,Exception>  {

        val response = try {
          api.getWeatherForecast(query = cityQuery)
        }catch (e: Exception){


            Log.d("INSIDE", "=exc============================================= getWeather e : $e")
            return DataOrException(e = e)
        }


        Log.d("INSIDE", "============================================== getWeather: $response")
        return DataOrException(data = response)

    }
}