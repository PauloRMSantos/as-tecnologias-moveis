package com.example.ticketnator.data.local

import com.example.ticketnator.data.local.dao.TicketDao
import com.example.ticketnator.data.local.entity.TicketEntity

class TicketLocalDataSource(private val ticketDao: TicketDao)  {
    fun getAllTickets() = ticketDao.getAllTickets()

    fun getTicketById(id: Int) = ticketDao.getTicketById(id)

    suspend fun insert(ticket: TicketEntity) = ticketDao.insert(ticket)
    suspend fun update(ticket: TicketEntity) = ticketDao.update(ticket)
    suspend fun delete(ticket: TicketEntity) = ticketDao.delete(ticket)

}