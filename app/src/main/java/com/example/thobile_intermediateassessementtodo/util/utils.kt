package com.example.thobile_intermediateassessementtodo.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.thobile_intermediateassessementtodo.model.Task
import kotlinx.coroutines.Job
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

fun formatDate(time:Long):String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())

    return format.format(date)
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertJobToTask(job: Job): Task {
    val isComplete = job.isCompleted
    return Task(
        title = "Sample Task",
        description = "This is a sample task description.",
        isComplete = isComplete
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun fromStringToTask(taskString: String): Task? {
    val regex = """Task\(id=([0-9a-fA-F-]+), title='([^']+)', description='([^']+)', isComplete=(true|false), entryDate=([^\)]+)\)""".toRegex()
    val matchResult = regex.find(taskString)

    return matchResult?.let {
        val (idString, title, description, isCompleteStr, entryDateStr) = it.destructured

        val id = UUID.fromString(idString)

        val entryDate = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(entryDateStr)

        val isComplete = isCompleteStr.toBoolean()

        Task(id = id, title = title, description = description, isComplete = isComplete, entryDate = entryDate ?: Date())
    }
}