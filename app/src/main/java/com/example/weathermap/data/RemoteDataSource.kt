package com.example.weathermap.data

import com.example.weathermap.model.Weather
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val weatherApi: WeatherApi) {
    suspend fun getWeather(queries: Map<String, String>): Weather{
        return weatherApi.getWeather(queries)
    }
}