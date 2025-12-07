package com.example.ticketnator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.ticketnator.data.model.Ticket
import com.example.ticketnator.databinding.TicketItemListBinding

class TicketAdapter(
    private val onDelete: (Ticket) -> Unit,
    private val onDetails: (Ticket) -> Unit,
    private val onEdit: (Ticket) -> Unit
) : ListAdapter<Ticket, TicketViewHolder>(TicketDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
       val binding = TicketItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(
            binding = binding,
            onDelete = onDelete,
            onDetails = onDetails,
            onEdit = onEdit
        )
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}