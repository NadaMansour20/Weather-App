package com.android.weatherapp.data.repository

import android.app.Activity
import android.location.Geocoder
import com.android.weatherapp.data.location.GetCurrentAddress
import java.util.Locale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAddressImpl : GetCurrentAddress {

    override suspend fun getCityName(
        activity: Activity,
        latitude: Double,
        longitude: Double
    ): String? = withContext(Dispatchers.IO) {
        try {
            val geocoder = Geocoder(activity, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            val address = addresses?.firstOrNull()
            val city = address?.subAdminArea ?: address?.locality ?: address?.adminArea
            city
        } catch (e: Exception) {
            null
        }
    }
}
