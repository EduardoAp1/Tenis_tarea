package com.example.tenis.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.tenis.data.TenisDatabase
import com.example.tenis.model.Tenis
import com.example.tenis.repository.TenisRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TenisViewModel(application: Application) : AndroidViewModel(application) {

    //Atributo para acceder al repositorio de lugar
    private val repository: TenisRepository


    val getAllData: LiveData<List<Tenis>>


    init{
        val tenisDao = TenisDatabase.getDataBase(application).tenisDao()
        repository = TenisRepository(tenisDao)
        getAllData = repository.getAllData
    }

    fun addTenis(tenis: Tenis){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTenis(tenis)
        }
    }

    fun updateTenis(tenis: Tenis){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTenis(tenis)
        }
    }

    fun deleteTenis(tenis: Tenis){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTenis(tenis)
        }
    }

}