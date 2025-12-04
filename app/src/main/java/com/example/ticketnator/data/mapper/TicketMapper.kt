package com.example.ticketnator.data.mapper

import com.example.ticketnator.data.local.entity.TicketEntity
import com.example.ticketnator.data.model.Ticket

fun Ticket.convertToEntity() =
    TicketEntity(
        title = this.title,
        description = this.description,
        createAt = this.createAt,
    )

fun TicketEntity.convertToModel() =
    Ticket(
        id = this.id,
        title = this.title,
        description = this.description,
        createAt
    )
