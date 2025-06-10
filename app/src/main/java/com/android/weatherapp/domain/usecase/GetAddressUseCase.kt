package com.android.weatherapp.domain.usecase

import android.app.Activity
import com.android.weatherapp.data.location.GetCurrentAddress

class GetAddressUseCase(
    private val getAddress: GetCurrentAddress
){

    suspend operator fun invoke(activity: Activity,lat:Double,long:Double): String? {
        return getAddress.getCityName(activity,lat,long)
    }

}