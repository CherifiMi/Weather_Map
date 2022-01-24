package com.example.weathermap.data

import com.example.weathermap.model.Weather
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @QueryMap queries: Map<String, String>
    ): Weather

}