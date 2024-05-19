package com.codeki.ticketapi.controller;

import com.codeki.ticketapi.model.CompanyDto;
import com.codeki.ticketapi.model.FlightDto;
import com.codeki.ticketapi.model.Ticket;
import com.codeki.ticketapi.services.FlightClient;
import com.codeki.ticketapi.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/add/{flightId}")
    public Ticket addTicketWithFlightId(@PathVariable Long flightId, @RequestBody Ticket ticket) {
        return ticketService.addTicketId(ticket, flightId);
    }

    @GetMapping("/flights")
    public List<FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @GetMapping("/companies")
    public List<CompanyDto> getAllCompanies(){
        return flightClient.getAllCompanies();
    }

    @GetMapping("/dolar")
    public double getDolar(){
        return flightClient.getDolar();
    }

    @GetMapping("/flight/{id}")
    public Optional<FlightDto> findFlightById(@PathVariable Long id){
        return flightClient.findFlightById();
    }

    @PutMapping("/update/{ticketId}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long ticketId, @RequestBody Ticket updatedTicket) {
        try {
            updatedTicket.setId(ticketId);
            Ticket updated = ticketService.updateTicket(updatedTicket);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {
        ticketService.deleteTicket(ticketId);
    }


    @GetMapping("/{ticketId}")
    public Ticket getTicketById(@PathVariable Long ticketId) {
        Optional<Ticket> ticketOptional = ticketService.findById(ticketId);
        return ticketOptional.orElse(null);
    }

    @GetMapping("/flights/origin/{origin}")
    public List<FlightDto> getFlightsByOrigin(@PathVariable String origin) {
        return flightClient.findFlightsByOrigin(origin);
    }

    @GetMapping("/flights/destination/{destination}")
    public List<FlightDto> getFlightsByDestination(@PathVariable String destination) {
        return flightClient.findFlightsByDestination(destination);
    }

    @GetMapping("/passport/{passport}")
    public List<FlightDto>  findTicketById(@PathVariable String passport) {
        return ticketService.findFlightsByPassport(passport);
    }

}
