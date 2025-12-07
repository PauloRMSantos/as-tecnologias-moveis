package com.example.ticketnator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ticketnator.data.model.Ticket
import com.example.ticketnator.databinding.FragmentFormUpdateTicketBinding
import com.example.ticketnator.ui.viewmodel.TicketViewModel
import kotlin.getValue

class FormUpdateTicketFragment  : Fragment(){
    private lateinit var binding: FragmentFormUpdateTicketBinding
    private val ticketViewModel: TicketViewModel by viewModels()
    val args: DetailsTicketFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormUpdateTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ticket = args.ticket

        binding.txvTitleUpdate.setText(ticket.title)
        binding.txvDescriptionUpdate.setText(ticket.description)

        binding.editButton.setOnClickListener {
            val editedTicket = Ticket(
                id = ticket.id,
                title = binding.txvTitleUpdate.text.toString(),
                description = binding.txvDescriptionUpdate.text.toString()
            )

            ticketViewModel.updateTicket(editedTicket)
            findNavController().popBackStack()
        }
    }
}