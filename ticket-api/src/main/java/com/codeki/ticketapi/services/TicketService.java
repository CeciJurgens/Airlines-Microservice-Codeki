package com.codeki.ticketapi.services;

import com.codeki.ticketapi.model.FlightDto;
import com.codeki.ticketapi.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    FlightClient flightClient;

    private final List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getAllTickets(){
        return tickets;
    }

    public Ticket addTicket(Ticket addedTicket){
        tickets.add(addedTicket);
        return addedTicket;
    }

    public Ticket addTicketId(Ticket ticket, Long id){
        FlightDto flightToTicket = flightClient.findFlightById().orElseThrow(()-> new RuntimeException("Flight with id" + id + "not found"));
        tickets.add(ticket);
        return ticket;
    }
}
