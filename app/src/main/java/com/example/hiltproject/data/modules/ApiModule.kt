package com.example.hiltproject.data.modules

import com.example.hiltproject.data.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @WeatherUrl
    @Provides
    @Singleton
    fun provideWeatherUrl(): String {
        return "https://api.weatherapi.com/v1/"
    }

    @GoogleUrl
    @Provides
    @Singleton
    fun provideGoogleUrl(): String {
        return "https://www.google.com/" // Replace with your actual Google URL
    }
    @WeatherUrl
    @Provides
    @Singleton
    fun getWeatherRetrofit(@WeatherUrl url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @GoogleUrl
    @Provides
    @Singleton
    fun getGoogleRetrofit(@GoogleUrl url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getWeatherApi(@WeatherUrl retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}

@Qualifier
annotation class WeatherUrl

@Qualifier
annotation class GoogleUrl