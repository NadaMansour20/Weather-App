package com.android.weatherapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import com.android.weatherapp.presentation.HomeScreen
import com.android.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            var isPermissionGranted by remember { mutableStateOf(false) }
            var isDay by remember { mutableStateOf<Boolean?>(null) }


            val permissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { granted ->
                isPermissionGranted = granted
            }

            LaunchedEffect(Unit) {
                val permission = Manifest.permission.ACCESS_FINE_LOCATION
                val granted = ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    permission
                ) == PackageManager.PERMISSION_GRANTED

                if (granted) {
                    isPermissionGranted = true
                } else {
                    permissionLauncher.launch(permission)
                }
            }

            WeatherAppTheme(darkTheme = isDay == false) {
                if (isPermissionGranted ) {
                    HomeScreen(
                        onDayStateChanged = { apiIsDay ->
                            isDay = apiIsDay == 1
                        }
                    )
                }
            }

        }
    }
}




