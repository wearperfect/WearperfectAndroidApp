package com.wearperfect.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wearperfect.android.app.navigation.RootNavigationHost
import com.wearperfect.android.app.ui.theme.WearperfectAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var rootNavController: NavHostController
    private lateinit var systemUiController: SystemUiController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            systemUiController = rememberSystemUiController()
            rootNavController = rememberNavController()
            val isDarkTheme = isSystemInDarkTheme()
            SideEffect {
                if(isDarkTheme){
                    systemUiController.setStatusBarColor(Color.Black)
                }else{
                    systemUiController.setStatusBarColor(Color.White)
                }
            }
            WearperfectApp(rootNavController)
        }
    }
}

@Composable
fun WearperfectApp(rootNavController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WearperfectAndroidAppTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    RootNavigationHost(rootNavController = rootNavController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WearperfectAndroidAppTheme {

    }
}