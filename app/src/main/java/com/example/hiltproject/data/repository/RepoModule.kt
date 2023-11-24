package com.example.hiltproject.data.repository

import com.example.hiltproject.data.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository = WeatherRepositoryImpl(api)
}