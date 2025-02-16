package com.example.thobile_intermediateassessementtodo.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.thobile_intermediateassessementtodo.model.Task

class TasksDataSource {

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadTasks() : List<Task>{
        return listOf(
            Task(title = "Go to gym", description = "Leg day", isComplete = false),
            Task(title = "study", description = "math - algebra and geometry", isComplete = true),
            Task(title = "A good day", description = "I prepare for life", isComplete = false),
            Task(title = "Meal prep", description = "Cook", isComplete = true),
        )
    }
}