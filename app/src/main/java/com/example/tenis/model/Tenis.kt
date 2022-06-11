package com.example.tenis.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="tenis")
data class Tenis(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="Marca")
    val marca: String,
    @ColumnInfo(name="Modelo")
    val modelo: String?,//signo de pregunta puede ser null
    @ColumnInfo(name="Talla")
    val talla: String?,
    @ColumnInfo(name="Precio")
    val precio: String?,
    @ColumnInfo(name="rutaImagen")
    val rutaImagen: String?,
) : Parcelable
