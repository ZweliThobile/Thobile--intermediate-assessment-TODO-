package com.example.thobile_intermediateassessementtodo.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thobile_intermediateassessementtodo.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class TaskViewModel @Inject constructor(private val repository: TaskRepository): ViewModel() {

    private val _taskList = MutableStateFlow<List<Task>>(emptyList())
    val taskList = _taskList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {

            repository.getAllTasks().distinctUntilChanged().collect {
                listOfTasks ->
                if (listOfTasks.isNullOrEmpty()){
                    Log.d("Empty", "Empty List")
                }else{
                    _taskList.value = listOfTasks
                }
            }
        }
    }

     fun addTask(task: Task)  = viewModelScope.launch { repository.addTask(task) }

      fun getTaskById(taskId: Int) = viewModelScope.launch { repository.getTaskById(taskId) }



     fun removeTask(task: Task) = viewModelScope.launch { repository.deleteTask(task) }

    suspend fun editTask(task: Task) = viewModelScope.launch { repository.updateTask(task) }

}