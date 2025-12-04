package com.example.ticketnator.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ticketnator.data.local.entity.TicketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticket: TicketEntity)

    @Query("SELECT * FROM tickets")
    fun getAllTickets(): Flow<List<TicketEntity>>

    @Query("SELECT * FROM tickets WHERE id = :id")
    fun getTicketById(id: Int): Flow<TicketEntity>

    @Delete
    suspend fun delete(ticket: TicketEntity)
}