package com.example.ticketnator.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tickets")
data class TicketEntity (
    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val createAt: String = "",
) : Serializable
