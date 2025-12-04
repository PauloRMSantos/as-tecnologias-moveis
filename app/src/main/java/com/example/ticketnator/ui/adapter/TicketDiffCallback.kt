package com.example.ticketnator.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ticketnator.data.model.Ticket

class TicketDiffCallback : DiffUtil.ItemCallback<Ticket>(){
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }
}