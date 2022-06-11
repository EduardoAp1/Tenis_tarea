package com.example.tenis.repository

import androidx.lifecycle.LiveData
import com.example.tenis.data.TenisDao
import com.example.tenis.model.Tenis

class TenisRepository(private val tenisDao: TenisDao) {

    suspend fun addTenis(tenis: Tenis){
        tenisDao.addTenis(tenis)
    }

    suspend fun updateTenis(tenis: Tenis){
        tenisDao.updateTenis(tenis)
    }

    suspend fun deleteTenis(tenis: Tenis){
        tenisDao.deleteTenis(tenis)
    }

    val getAllData : LiveData<List<Tenis>> = tenisDao.getAllData()
}