package com.example.tenis.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tenis.model.Tenis

@Database(entities = [Tenis::class], version = 1, exportSchema = false)
abstract class TenisDatabase: RoomDatabase() {
    abstract fun tenisDao() : TenisDao

    companion object{

        @Volatile
        private var INSTANCE: TenisDatabase? = null

        fun getDataBase(context: android.content.Context) : TenisDatabase {
            val temp =  INSTANCE
            if(temp != null){
                return temp
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TenisDatabase::class.java,
                    "tenis_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}