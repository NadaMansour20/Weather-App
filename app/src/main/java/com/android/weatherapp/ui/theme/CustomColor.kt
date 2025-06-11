package com.android.weatherapp.ui.theme

import androidx.compose.ui.graphics.Color

import androidx.compose.runtime.staticCompositionLocalOf

val LocalCustomColors = staticCompositionLocalOf<CustomColors> { LightCustomColors }

interface CustomColors


object LightCustomColors:CustomColors {
    val Gray=Color(0xFF323232)
    val backgroundColor=Color(0xFF87CEFA)
    val Black=Color(0xFF060414)
    val Black60=Color(0x99060414)
    val Gray8=Color(0x14060414)
    val Gray24=Color(0x3D060414)
    val BlueLight=Color(0xFF87CEFA)
    val Black87=Color(0xDE060414)
    val White70=Color(0xB3FFFFFF)
    val White=Color(0xFFFFFFFF)
}

object DarkCustomColors :CustomColors{
    val White24=Color(0x3DFFFFFF)
    val White=Color(0xFFFFFFFF)
    val White8=Color(0x14FFFFFF)
    val White60=Color(0x99FFFFFF)
    val Black70=Color(0xB3060414)
    val White87=Color(0xDEFFFFFF)
    val backgroundDarkGradient1=Color(0xFF060414)
    val backgroundDarkGradient2=Color(0xFF0D0C19)
}
