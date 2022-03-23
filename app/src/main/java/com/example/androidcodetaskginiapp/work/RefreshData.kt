package com.example.androidcodetaskginiapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.androidcodetaskginiapp.repository.ImageRepository
import com.udacity.hit.database.ImageDataBase
import retrofit2.HttpException

class RefreshData(appContext: Context, params: WorkerParameters): CoroutineWorker(appContext,params){
    companion object{
        const val WORK_NAME = "RefreshData"
    }
    override suspend fun doWork(): Result {
        val database = ImageDataBase.getDatabase(applicationContext)
        val repository = ImageRepository(database)
        return try {
            repository.refreshHits()
            Result.success()
        } catch (exception: HttpException){
            Result.retry()
        }
    }
}