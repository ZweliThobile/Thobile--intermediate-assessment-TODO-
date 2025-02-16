package com.example.thobile_intermediateassessementtodo.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "tasks_tbl")
data class Task @RequiresApi(Build.VERSION_CODES.O) constructor(

    @PrimaryKey
    val id : UUID = UUID.randomUUID(),

    @ColumnInfo(name = "task_title")
    val title: String,

    @ColumnInfo(name = "task_description")
    val description: String,

    @ColumnInfo(name = "task_status")
    val isComplete: Boolean,

    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)