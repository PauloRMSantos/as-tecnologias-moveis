package com.example.ticketnator.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ticketnator.data.TicketRepository
import com.example.ticketnator.data.local.TicketLocalDataSource
import com.example.ticketnator.data.local.database.AppDatabase
import com.example.ticketnator.data.model.Ticket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TicketViewModel(application: Application) : AndroidViewModel(application) {
    private val ticketDao = AppDatabase.getInstance(application).ticketDao()
    private val localDataSource = TicketLocalDataSource(ticketDao)
    private val repository = TicketRepository(localDataSource)

    private val _ticketList = repository.getAllTickets().asLiveData()
    val ticketList: LiveData<List<Ticket>> = _ticketList

    fun removeTicket(ticket: Ticket) = viewModelScope.launch(Dispatchers.IO) {
        repository.remove(ticket)
    }

    fun addTicket(ticket: Ticket) = viewModelScope.launch(Dispatchers.IO) {
        repository.add(ticket)
    }

    fun updateTicket(ticket: Ticket) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(ticket)
    }
}