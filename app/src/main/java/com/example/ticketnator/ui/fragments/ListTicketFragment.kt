package com.example.ticketnator.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketnator.data.model.Ticket
import com.example.ticketnator.databinding.FragmentListTicketBinding
import com.example.ticketnator.ui.adapter.TicketAdapter
import com.example.ticketnator.ui.viewmodel.TicketViewModel

class ListTicketFragment : Fragment() {
    private lateinit var binding: FragmentListTicketBinding
    private lateinit var adapter: TicketAdapter
    private val ticketViewModel: TicketViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ticketViewModel.ticketList.observe(viewLifecycleOwner) { ticket ->
            adapter.submitList(ticket.toMutableList())
        }

        binding = FragmentListTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc = binding.recyclerView
        adapter = TicketAdapter(
            onDelete = { ticket ->
                ticketViewModel.removeTicket(ticket)
            },
            onDetails = { ticket ->
                goToDetails(ticket = ticket)
            },
        )
        rc.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val action = ListTicketFragmentDirections.actionListTicketFragmentToFormTicketFragment()
            findNavController().navigate(action)
        }
    }

    private fun goToDetails(ticket: Ticket) {
        val action = ListTicketFragmentDirections.actionListTicketFragmentToDetailsTicketFragment(ticket)
        findNavController().navigate(action)
    }
}