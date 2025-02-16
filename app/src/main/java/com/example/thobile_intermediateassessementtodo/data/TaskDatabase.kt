package com.example.thobile_intermediateassessementtodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnoteapp.util.TimeConverter
import com.example.jetnoteapp.util.UUIDConverter
import com.example.thobile_intermediateassessementtodo.model.Task


@Database(entities = [Task::class], version = 1, exportSchema = false)

@TypeConverters(TimeConverter::class, UUIDConverter::class)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun noteDao(): TaskDatabaseDao
}