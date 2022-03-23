package com.example.androidcodetaskginiapp.repository

import com.example.androidcodetaskginiapp.api.ApiService
import com.example.androidcodetaskginiapp.asDomainModel
import com.example.androidcodetaskginiapp.model.Hit
import com.udacity.hit.database.ImageDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList

class ImageRepository(private val database: ImageDataBase) {

    suspend fun refreshHits() {
        withContext(Dispatchers.IO) {
            val imageList = ApiService.retrofitService.getImages()
            val hitList = imageList.hits as ArrayList<Hit>
            database.hitDataBaseDao.insertAll(*hitList.asDomainModel())
        }
    }

    suspend fun getAllHits():List<Hit>{
        lateinit var result:List<Hit>
        withContext(Dispatchers.IO){
            result = database.hitDataBaseDao.getAllHits(50,50)
        }
        return result
    }
}
