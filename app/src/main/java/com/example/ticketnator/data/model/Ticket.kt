package com.example.ticketnator.data.model

import java.io.Serializable
import java.util.Date

data class Ticket (
    val id: Int = 0,
    val title: String,
    val description: String,
    val createAt: String = "2025",
) : Serializable