package com.example.androidcodetaskginiapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidcodetaskginiapp.model.Hit
import com.example.androidcodetaskginiapp.repository.ImageRepository
import com.udacity.hit.database.ImageDataBase
import kotlinx.coroutines.launch
import java.util.*

class MainScreenViewModel(application: Application) : AndroidViewModel(application) {

    private val database = ImageDataBase.getDatabase(application.applicationContext)
    private val imageRepository = ImageRepository(database)

    private var _response = MutableLiveData<List<Hit>>()
    val response: LiveData<List<Hit>> get() = _response


    init {
        getImages()
        refreshImages()
    }

    private fun refreshImages() {
        viewModelScope.launch {
            try {
                imageRepository.refreshHits()
                _response.value = imageRepository.getAllHits()
            } catch (e: Exception) {
                println("Exception refreshing data: $e.message")
            }
        }
    }
    private fun getImages() {
        viewModelScope.launch {
            try {
                _response.value = imageRepository.getAllHits()
            } catch (e: Exception) {
                println("Exception refreshing data: $e.message")
            }
        }
    }
}