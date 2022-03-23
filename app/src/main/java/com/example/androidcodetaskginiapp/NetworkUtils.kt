package com.example.androidcodetaskginiapp

import com.example.androidcodetaskginiapp.database.DatabaseHit
import com.example.androidcodetaskginiapp.model.Hit

fun ArrayList<Hit>.asDomainModel(): Array<DatabaseHit> {
    return map {
        DatabaseHit(
            id = it.id,
            collections = it.collections,
            downloads = it.downloads,
            imageHeight = it.imageHeight,
            imageSize = it.imageSize,
            imageWidth = it.imageWidth,
            largeImageURL = it.largeImageURL,
            likes = it.likes,
            pageURL = it.pageURL,
            previewHeight = it.previewHeight,
            previewURL = it.previewURL,
            previewWidth = it.previewWidth,
            tags = it.tags,
            type = it.type,
            user = it.user,
            userImageURL = it.userImageURL,
            user_id = it.user_id,
            views = it.views,
            webformatHeight = it.webformatHeight,
            webformatURL = it.webformatURL,
            webformatWidth = it.webformatWidth,
            comments = it.comments
        )
    }
        .toTypedArray()
}