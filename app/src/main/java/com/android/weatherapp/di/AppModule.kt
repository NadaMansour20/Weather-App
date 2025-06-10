package com.android.weatherapp.di

import com.android.weatherapp.data.location.GetCurrentAddress
import com.android.weatherapp.data.location.GetCurrentLocation
import com.android.weatherapp.data.remote.datasource.WeatherService
import com.android.weatherapp.data.repository.GetAddressImpl
import com.android.weatherapp.data.repository.GetLocationImpl
import com.android.weatherapp.data.repository.WeatherRepositoryImpl
import com.android.weatherapp.domain.repository.WeatherRepository
import com.android.weatherapp.domain.usecase.GetAddressUseCase
import com.android.weatherapp.domain.usecase.GetLocationUseCase
import com.android.weatherapp.domain.usecase.GetWeatherForecastUseCase
import com.android.weatherapp.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { WeatherService.create() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    viewModel { HomeViewModel(get()) }

    single { GetAddressUseCase(get()) }
    single { GetLocationUseCase(get()) }
    single { GetWeatherForecastUseCase(get()) }

    single<GetCurrentLocation> { GetLocationImpl() }
    single<GetCurrentAddress> { GetAddressImpl() }
}