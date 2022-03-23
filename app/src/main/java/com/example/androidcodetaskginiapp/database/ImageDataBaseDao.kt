package com.udacity.hit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidcodetaskginiapp.database.DatabaseHit
import com.example.androidcodetaskginiapp.model.Hit

@Dao
interface ImageDataBaseDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg hits: DatabaseHit)

    @Query("SELECT * FROM DatabaseHit WHERE likes > :recomendedLikes AND comments > :recomendedComments ORDER BY likes DESC")
    fun getAllHits(recomendedLikes:Int,recomendedComments:Int):List<Hit>

}

