package com.example.timer.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.timer.Timer
import com.example.timer.instagramUI.ProfileScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route =  Screen.DetailScreen.route +"/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue ="Enock"
                    nullable = true
                }
            )){entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
        composable("instagram"){
            ProfileScreen(navController )
        }
        composable("Timer"){
                        Timer(
                            totalTime = 100L * 1000L,
                            handleColor = Color.Green,
                            inactiveBarColor = Color.DarkGray,
                            activeBarColor = Color(0xFF37B900),
                            modifier = Modifier.size(200.dp)
                        )        }
    }

}

sealed class Screen(
    val route: String
){
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")

    fun withArgs(args: String): String{
        return buildString {
            append(route)
            append("/")
            args.forEach {arg ->
                append("$arg")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){
    var text by remember {
        mutableStateOf("")
    }
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ){
        TextField(value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
            )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
                         navController.navigate(Screen.DetailScreen.withArgs(text))
        },
            modifier = Modifier.align(Alignment.End)) {
            Text(
                text = "Go to Details Screen"
            )
        }
        Button(onClick = {
                         navController.navigate("Timer")
        },
            modifier = Modifier.align(Alignment.End)) {
            Text(
                text = "Open Timer"
            )
        }
        Button(onClick = {
            navController.navigate("instagram")
        }) {
            Text(text = "Go to Instagram")
        }
    }
}

@Composable
fun DetailScreen(name: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Hello $name")
    }
}