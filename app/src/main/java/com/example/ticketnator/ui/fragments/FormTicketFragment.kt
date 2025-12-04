package com.example.ticketnator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ticketnator.data.model.Ticket
import com.example.ticketnator.databinding.FragmentFormTicketBinding
import com.example.ticketnator.ui.viewmodel.TicketViewModel

class FormTicketFragment : Fragment(){
    private lateinit var binding: FragmentFormTicketBinding
    private val ticketViewModel: TicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val ticket = Ticket(
                title = binding.txvTitle.text.toString(),
                description = binding.txvDescription.text.toString()
            )

            ticketViewModel.addTicket(ticket)
            val action = FormTicketFragmentDirections.actionFormTicketFragmentToListTicketFragment()
            findNavController().navigate(action)
        }
    }
}