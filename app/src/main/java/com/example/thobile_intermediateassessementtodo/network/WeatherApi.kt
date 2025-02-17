package com.example.thobile_intermediateassessementtodo.network

import com.example.thobile_intermediateassessementtodo.model.WeatherObject
import com.example.thobile_intermediateassessementtodo.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface WeatherApi {

    //http://api.weatherapi.com/v1/current.json?key=d8aa9d3a81fa46d9aba25049251602&q=Springs&aqi=no

    @GET(value = "forecast.json?")
    suspend fun getWeatherForecast(
        @Query(value = "key") key: String = Constants.API_KEY,
        @Query(value = "q") query: String,
        @Query(value = "aqi") aqi: String = "no"
    ):WeatherObject
}