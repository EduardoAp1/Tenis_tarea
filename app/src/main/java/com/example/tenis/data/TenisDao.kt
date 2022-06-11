package com.example.tenis.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tenis.model.Tenis

@Dao
interface TenisDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTenis(lugar: Tenis)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTenis(lugar: Tenis)

    @Delete
    suspend fun deleteTenis(lugar: Tenis)

    @Query("SELECT * FROM TENIS")
    fun getAllData() : LiveData<List<Tenis>>

}