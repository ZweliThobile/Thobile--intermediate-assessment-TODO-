package com.example.thobile_intermediateassessementtodo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thobile_intermediateassessementtodo.screens.AddTaskScreen
import com.example.thobile_intermediateassessementtodo.screens.HomeScreen
import com.example.thobile_intermediateassessementtodo.screens.HomeViewModel
import com.example.thobile_intermediateassessementtodo.screens.TasksScreen
import com.example.thobile_intermediateassessementtodo.screens.ViewTaskScreen


@OptIn(ExperimentalComposeUiApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TodoScreens.HomeScreen.name){

        composable(TodoScreens.HomeScreen.name){
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController,homeViewModel)
        }

        composable(TodoScreens.TasksScreen.name){
            TasksScreen(navController, emptyList())
        }

        composable(TodoScreens.AddTasksScreen.name){
            AddTaskScreen(navController)
        }

        composable(TodoScreens.ViewTaskScreen.name+"/{task}",
        arguments = listOf(navArgument(name = "task"){type = NavType.StringType})
        ){
            backStackEntry ->
            ViewTaskScreen(navController,backStackEntry.arguments?.getString("task"))
        }





    }

}