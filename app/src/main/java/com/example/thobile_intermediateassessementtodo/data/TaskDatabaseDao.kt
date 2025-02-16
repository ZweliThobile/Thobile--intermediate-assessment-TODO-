package com.example.thobile_intermediateassessementtodo.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.thobile_intermediateassessementtodo.model.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDatabaseDao {

    @Query("SELECT * from tasks_tbl")
    fun getTasks(): Flow<List<Task>>

    @Query("SELECT * from tasks_tbl where id =:id")
    suspend fun getTaskById(id:String) : Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(task: Task)

    @Query("DELETE from tasks_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteTask(task: Task)



}
