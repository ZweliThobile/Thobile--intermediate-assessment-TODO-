package com.example.thobile_intermediateassessementtodo.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thobile_intermediateassessementtodo.R
import com.example.thobile_intermediateassessementtodo.model.Task
import com.example.thobile_intermediateassessementtodo.model.TaskViewModel
import com.example.thobile_intermediateassessementtodo.reusableComponents.InputText
import com.example.thobile_intermediateassessementtodo.reusableComponents.uiButton


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun AddTaskScreen(
    navController: NavController

) {


    var title by remember {
        mutableStateOf(value = "")
    }

    var description by remember {
        mutableStateOf(value = "")
    }



    val taskViewModel: TaskViewModel = viewModel()
    val tasks by taskViewModel.taskList.collectAsState(initial = emptyList())


    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.add_tasks_screen))
        })

        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InputText(modifier = Modifier.padding(top = 9.dp),
                text = title, label = stringResource(id = R.string.title), onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() })
                        title = it
                })

            InputText(modifier = Modifier.padding(top = 9.dp, bottom = 15.dp),
                text = description, label = stringResource(id = R.string.add_a_note), onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() })
                        description = it
                })

            uiButton(text = stringResource(id = R.string.save), onClick = { if (title.isNotEmpty() && description.isNotEmpty()){

               

                taskViewModel.addTask(Task(title = title,
                    description = description, isComplete = false))
                title = " "
                description = " "

                Toast.makeText(context,"Note added", Toast.LENGTH_SHORT).show()
            }
            })
        }

    }
}




@OptIn(ExperimentalComposeUiApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun AddTasksPreview(){
    val navController = rememberNavController()
    AddTaskScreen(navController = navController)



}