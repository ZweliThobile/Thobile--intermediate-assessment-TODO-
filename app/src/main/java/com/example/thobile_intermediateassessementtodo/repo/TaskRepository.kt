package com.example.thobile_intermediateassessementtodo.repo


import com.example.thobile_intermediateassessementtodo.data.TaskDatabaseDao
import com.example.thobile_intermediateassessementtodo.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDatabaseDao: TaskDatabaseDao){

    suspend fun addTask(task: Task) = taskDatabaseDao.insert(task)
    suspend fun updateTask(task: Task) = taskDatabaseDao.update(task)
    suspend fun deleteTask(task: Task) = taskDatabaseDao.deleteTask(task)
    suspend fun deleteAllTasks() = taskDatabaseDao.deleteAll()
     fun getAllTasks() : Flow<List<Task>> = taskDatabaseDao.getTasks().flowOn(Dispatchers.IO).conflate()

}