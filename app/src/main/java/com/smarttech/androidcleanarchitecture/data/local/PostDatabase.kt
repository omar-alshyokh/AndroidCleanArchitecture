package com.smarttech.androidcleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smarttech.androidcleanarchitecture.module.main.data.local.entity.PostDao
import com.smarttech.androidcleanarchitecture.data.local.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}