package com.bawp.jetweatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bawp.jetweatherforecast.screens.main.MainScreen
import com.bawp.jetweatherforecast.ui.theme.AppTheme
import com.bawp.jetweatherforecast.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var application: WeatherApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(theme = application.currentTheme.value) {
                WeatherApp(onToggleTheme = { application.changeTheme(Theme.Light)},
                    onToggleDarkMode = { application.changeTheme(Theme.Dark)})
            }

        }
    }
}

//this is probably a bad way to implement the theming, going to improve on this later.
@Composable
fun WeatherApp(onToggleTheme: () -> Unit, onToggleDarkMode: () -> Unit) {


               Column(verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally) {
                   val navController = rememberNavController()

                   MainScreen(navController = navController, onToggleTheme = onToggleTheme, onToggleDarkMode = onToggleDarkMode)
               }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme(theme = Theme.Dark) {

    }
}