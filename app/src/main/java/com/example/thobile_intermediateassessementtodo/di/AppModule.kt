package com.example.thobile_intermediateassessementtodo.di

import android.content.Context
import androidx.room.Room
import com.example.thobile_intermediateassessementtodo.data.TaskDatabase
import com.example.thobile_intermediateassessementtodo.data.TaskDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: TaskDatabase):TaskDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):TaskDatabase
            = Room.databaseBuilder(context,TaskDatabase::class.java, name = "task_db").fallbackToDestructiveMigration().build()

}