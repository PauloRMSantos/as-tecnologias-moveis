package com.example.ticketnator.ui.adapter


import androidx.recyclerview.widget.RecyclerView
import com.example.ticketnator.data.model.Ticket
import com.example.ticketnator.databinding.TicketItemListBinding

class TicketViewHolder(
    private val binding: TicketItemListBinding,
    private val onDelete: (Ticket) -> Unit,
    private val onDetails: (Ticket) -> Unit,
    private val onEdit: (Ticket) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        binding.ticket = ticket

        binding.actionDelete.setOnLongClickListener {
            onDelete(ticket)
            true
        }
        binding.actionDetails.setOnClickListener {
            onDetails(ticket)
        }
        binding.actionUpdate.setOnClickListener {
            onEdit(ticket)
        }
    }
}