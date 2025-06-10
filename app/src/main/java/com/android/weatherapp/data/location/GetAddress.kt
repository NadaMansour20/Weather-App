package com.android.weatherapp.data.location

import android.app.Activity

interface GetCurrentAddress {
    suspend fun getCityName(activity: Activity, latitude: Double, longitude: Double): String?
}
