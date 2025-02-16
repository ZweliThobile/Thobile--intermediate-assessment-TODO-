package com.example.thobile_intermediateassessementtodo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thobile_intermediateassessementtodo.screens.AddTaskScreen
import com.example.thobile_intermediateassessementtodo.screens.HomeScreen
import com.example.thobile_intermediateassessementtodo.screens.TasksScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TodoScreens.HomeScreen.name){

        composable(TodoScreens.HomeScreen.name){
            HomeScreen(navController, emptyList(), onTaskClicked = {})
        }

        composable(TodoScreens.TasksScreen.name){
            TasksScreen(navController, emptyList())
        }

        composable(TodoScreens.AddTasksScreen.name){
            AddTaskScreen(navController)
        }

    }

}