package com.example.ticketnator.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.ticketnator.databinding.FragmentDetailsTicketBinding

class DetailsTicketFragment : Fragment(){
    private lateinit var binding: FragmentDetailsTicketBinding
    val args: DetailsTicketFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ticketArgs = args.ticket
        binding.ticket = ticketArgs

    }
}