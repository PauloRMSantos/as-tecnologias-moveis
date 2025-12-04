package com.example.ticketnator.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ticketnator.data.local.dao.TicketDao
import com.example.ticketnator.data.local.entity.TicketEntity


@Database(entities = [TicketEntity::class, ], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todo_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}