package com.example.ticketnator.data

import com.example.ticketnator.data.local.TicketLocalDataSource
import com.example.ticketnator.data.mapper.convertToEntity
import com.example.ticketnator.data.mapper.convertToModel
import com.example.ticketnator.data.model.Ticket
import kotlinx.coroutines.flow.map

class TicketRepository(private val dataSource: TicketLocalDataSource) {
    fun getAllTickets() = dataSource.getAllTickets().map { it.map { it.convertToModel() }  }
    fun getTicketById(id: Int) = dataSource.getTicketById(id).map { it.convertToModel() }

    suspend fun remove(ticket: Ticket) = dataSource.delete(ticket.convertToEntity())
    suspend fun add(ticket: Ticket) = dataSource.insert(ticket.convertToEntity())

}