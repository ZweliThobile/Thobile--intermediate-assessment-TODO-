package com.example.thobile_intermediateassessementtodo.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thobile_intermediateassessementtodo.R
import com.example.thobile_intermediateassessementtodo.data.TasksDataSource
import com.example.thobile_intermediateassessementtodo.model.Task
import com.example.thobile_intermediateassessementtodo.navigation.TodoScreens
import com.example.thobile_intermediateassessementtodo.reusableComponents.TaskItem


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    navController: NavController,
    tasks : List<Task>,
) {

    val tempTasks : List<Task> = TasksDataSource().loadTasks()
    val completedTasks = tempTasks.filter { it.isComplete }
    val incompleteTasks = tempTasks.filter { !it.isComplete }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(6.dp)) {

        TopAppBar(title = {
            Text(text = stringResource(id = R.string.tasks_screen))
        }, actions = {
            Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = "Icon", modifier = Modifier.clickable {
                navController.navigate(TodoScreens.AddTasksScreen.name) })
        })

        // Incomplete Tasks
        Text(
            text = "Incomplete Tasks",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(incompleteTasks) { task ->
                TaskItem(task)
            }
        }

        Divider(modifier = Modifier.padding(10.dp))

        // Completed Tasks
        Text(
            text = "Completed Tasks",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(completedTasks) { task ->
                TaskItem(task)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun TasksScreenPreview(){
    val navController = rememberNavController()
    TasksScreen(navController = navController, tasks = emptyList())



}