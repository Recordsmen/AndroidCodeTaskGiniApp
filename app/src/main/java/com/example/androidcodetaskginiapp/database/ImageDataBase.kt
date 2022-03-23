package com.udacity.hit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidcodetaskginiapp.database.DatabaseHit

@Database(entities = [ DatabaseHit::class], version = 1)

abstract class ImageDataBase:RoomDatabase() {

    abstract val hitDataBaseDao: ImageDataBaseDao

    companion object{
        @Volatile
        private var INSTANCE:ImageDataBase? = null

        fun getDatabase(context: Context): ImageDataBase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ImageDataBase::class.java,
                        "image-database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
                }
            }
        }

    }

