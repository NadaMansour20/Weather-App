package com.android.weatherapp.data.location

import android.app.Activity
import android.location.Location

interface GetCurrentLocation {

    suspend fun getCurrentLocation(activity: Activity):Location?
}