package com.android.weatherapp.domain.usecase

import android.app.Activity
import android.location.Location
import com.android.weatherapp.data.location.GetCurrentLocation

class GetLocationUseCase(
    private val getLocation: GetCurrentLocation
){

    suspend operator fun invoke(activity: Activity): Location? {
        return getLocation.getCurrentLocation(activity)
    }

}