package com.example.thobile_intermediateassessementtodo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thobile_intermediateassessementtodo.navigation.AppNavigation
import com.example.thobile_intermediateassessementtodo.ui.theme.ThobileintermediateAssessementTODOTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          TodoApp()
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoApp(){

    ThobileintermediateAssessementTODOTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,

        ) {

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                AppNavigation()

            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThobileintermediateAssessementTODOTheme {
    }
}