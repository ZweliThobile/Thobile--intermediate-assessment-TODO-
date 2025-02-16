package com.example.thobile_intermediateassessementtodo.screens

import android.graphics.drawable.Icon
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.thobile_intermediateassessementtodo.R
import com.example.thobile_intermediateassessementtodo.model.Task
import com.example.thobile_intermediateassessementtodo.navigation.TodoScreens
import com.example.thobile_intermediateassessementtodo.reusableComponents.InputText
import com.example.thobile_intermediateassessementtodo.reusableComponents.uiButton
import com.example.thobile_intermediateassessementtodo.util.formatDate


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    tasks : List<Task>,
    onTaskClicked: (Task) -> Unit
) {

    
    Column(modifier = Modifier
        .padding(6.dp)
        .fillMaxHeight()) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.home_screen))
        })


        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .padding(top = 15.dp, bottom = 15.dp)
                .background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Weather scope")




        }

        Divider(modifier = Modifier.padding(10.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
            .background(Color.LightGray)
            .padding(start = 10.dp, top = 5.dp)) {
            Text(text = "Favourites",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
            .clickable {
navController.navigate(TodoScreens.TasksScreen.name)
            }
            .background(Color.LightGray)
            .padding(start = 10.dp, top = 5.dp),
            ) {
            Text(text = "My Tasks",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }

        LazyColumn{

            items(tasks){ task ->
                //Text(text = Task.title)

                TaskRow(Task = task, onTaskClicked = {
                    onTaskClicked(task)
                })

            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskRow(
    modifier: Modifier = Modifier,
    Task:Task,
    onTaskClicked: (Task) -> Unit){

    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB), shadowElevation = 6.dp){

        Column(
            modifier
                .clickable { onTaskClicked(Task) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {

            Text(text = Task.title, style = MaterialTheme.typography.bodyLarge )
            Text(text = Task.description, style = MaterialTheme.typography.bodyMedium )
            Text(text = formatDate(Task.entryDate.time), style = MaterialTheme.typography.bodySmall )


        }

    }

}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    HomeScreen(navController = navController, tasks = emptyList(), onTaskClicked = {})



}
