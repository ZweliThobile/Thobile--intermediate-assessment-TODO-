package com.example.thobile_intermediateassessementtodo.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.thobile_intermediateassessementtodo.R
import com.example.thobile_intermediateassessementtodo.model.TaskViewModel
import com.example.thobile_intermediateassessementtodo.util.fromStringToTask

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
 fun ViewTaskScreen(taskId: NavHostController, task: String?,taskViewModel: TaskViewModel = hiltViewModel()) {

 val taskObject = task?.let { fromStringToTask(it) }

 Column(modifier = Modifier.fillMaxSize().padding(6.dp)) {
  TopAppBar(title = {
   Text(text = stringResource(id = R.string.view_tasks_screen))
  })

  if (taskObject != null) {
   Text(text = taskObject.title)
   Text(text = taskObject.description)
  }

 }


}