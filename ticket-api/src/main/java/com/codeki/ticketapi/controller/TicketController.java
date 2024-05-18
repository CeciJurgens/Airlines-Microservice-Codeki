package com.codeki.ticketapi.controller;

import com.codeki.ticketapi.model.FlightDto;
import com.codeki.ticketapi.model.Ticket;
import com.codeki.ticketapi.services.FlightClient;
import com.codeki.ticketapi.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    FlightClient flightClient;

    @GetMapping("")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket){
        return ticketService.addTicket(ticket);
    }

    @GetMapping("/flights")
    public List<FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @GetMapping("/dolar")
    public double getDolar(){
        return flightClient.getDolar();
    }

    @GetMapping("/flight/{id}")
    public Optional<FlightDto> findFlightById(@PathVariable Long id){
        return flightClient.findFlightById();
    }
}
