package com.example.hiltproject.data.modules

import com.example.hiltproject.data.repository.WeatherRepository
import com.example.hiltproject.data.useCase.GetCurrentWeatherInteraction
import com.example.hiltproject.data.useCase.GetCurrentWeatherUseCase
import com.example.hiltproject.data.useCase.SearchWeatherInteraction
import com.example.hiltproject.data.useCase.SearchWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideSearchWeatherUseCase(repo: WeatherRepository): SearchWeatherUseCase =
        SearchWeatherInteraction(repo)

    @Provides
    fun provideGetCurrentWeatherUseCase(repo: WeatherRepository): GetCurrentWeatherUseCase =
        GetCurrentWeatherInteraction(repo)
}