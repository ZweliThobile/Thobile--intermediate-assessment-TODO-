package com.example.thobile_intermediateassessementtodo.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.thobile_intermediateassessementtodo.R
import com.example.thobile_intermediateassessementtodo.data.TasksDataSource
import com.example.thobile_intermediateassessementtodo.model.Task
import com.example.thobile_intermediateassessementtodo.model.TaskViewModel
import com.example.thobile_intermediateassessementtodo.navigation.TodoScreens
import com.example.thobile_intermediateassessementtodo.reusableComponents.TaskItem


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    navController: NavController,
    tasks : List<Task>,
    taskViewModel: TaskViewModel = hiltViewModel()
) {


    var tasks = taskViewModel.taskList.collectAsState().value
    val tempTasks : List<Task> = TasksDataSource().loadTasks() //test taskList for preview, may I ask if there is a way to have a viewModel in a preview?
    val completedTasks = tasks.filter { it.isComplete }
    val incompleteTasks = tasks.filter { !it.isComplete }
    val context = LocalContext.current
    var draggedIndex by remember { mutableStateOf(-1) }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(6.dp)) {

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


        LazyColumn(modifier = Modifier.weight(1f)
        ) {
            itemsIndexed(tasks) { index, task ->
                TaskItem(
                    task = task,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .pointerInput(Unit) {
                            detectDragGestures { _, dragAmount ->
                                // Handle the drag gesture
                                if (draggedIndex == -1) {
                                    draggedIndex = index // Start dragging this task
                                }

                                // Perform drag logic to reorder the task list
                                if (draggedIndex >= 0) {
                                    val newIndex = (index + dragAmount.y.toInt()).coerceIn(0, tasks.size - 1)
                                    if (newIndex != draggedIndex) {
                                        // Swap items to reflect the drag
                                        val updatedList = tasks.toMutableList().apply {
                                            add(newIndex, removeAt(draggedIndex))
                                        }
                                        tasks = updatedList
                                        draggedIndex = newIndex
                                    }
                                }
                            }
                        } .clickable {
                            navController.navigate(TodoScreens.ViewTaskScreen.name + "/${task.id}")
                        }
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
                TaskItem(task) {
                    val route = TodoScreens.ViewTaskScreen.name
                    navController.navigate("$route/${task.id}")
                }
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun TasksScreenPreview(){
//    val navController = rememberNavController()
//    TasksScreen(navController = navController, tasks = emptyList())
//
//
//
//}