package com.codeki.ticketapi.services;

import com.codeki.ticketapi.model.FlightDto;
import com.codeki.ticketapi.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        ticket.setFlight(flightToTicket);
        tickets.add(ticket);
        return ticket;
    }

    public Optional<Ticket> findById(Long ticketId) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(ticketId))
                .findFirst();
    }

    public List<FlightDto> findFlightsByPassport(String passport) {
        return tickets.stream()
                .filter(ticket -> ticket.getPassengerPassport().equalsIgnoreCase(passport))
                .map(Ticket::getFlight)
                .collect(Collectors.toList());
    }

    public Ticket updateTicket(Ticket updatedTicket) {
        Optional<Ticket> existingTicketOptional = findById(updatedTicket.getId());

        if (existingTicketOptional.isPresent()) {
            Ticket existingTicket = existingTicketOptional.get();
            existingTicket.setPassengerName(updatedTicket.getPassengerName());
            existingTicket.setPassengerEmail(updatedTicket.getPassengerEmail());
            existingTicket.setPassengerPassport(updatedTicket.getPassengerPassport());
            return existingTicket;
        } else {
            throw new IllegalArgumentException("Ticket not found with ID: " + updatedTicket.getId());
        }
    }


    public void deleteTicket(Long ticketId) {
        Optional<Ticket> ticketOptional = findById(ticketId);

        if (ticketOptional.isPresent()) {
            tickets.remove(ticketOptional.get());
        } else {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
        }
    }
}
