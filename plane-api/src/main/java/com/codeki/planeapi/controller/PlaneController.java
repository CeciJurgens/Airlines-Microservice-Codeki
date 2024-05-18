package com.codeki.planeapi.controller;

import com.codeki.planeapi.model.FlightDto;
import com.codeki.planeapi.model.Plane;
import com.codeki.planeapi.model.Ticket;
import com.codeki.planeapi.service.FlightClient;
import com.codeki.planeapi.service.PlaneService;
import com.codeki.planeapi.service.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private FlightClient flightClient;
    @Autowired
    private TicketClient ticketClient;

    @GetMapping("")
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @PostMapping("/add")
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.createPlane(plane);
    }

    @GetMapping("/flights")
    public List<FlightDto> getAllFlights() {
        return flightClient.getAllFlights();
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketClient.getAllTickets();
    }

    @GetMapping("/flights-by-company/{companyId}")
    public ResponseEntity<?> getFlightsByCompany(@PathVariable Long companyId) {
        List<FlightDto> flights = flightClient.getFlightsByCompany(companyId);
        if (flights.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/flights-by-frequency/{frequency}")
    public ResponseEntity<?> getFlightsByFrequency(@PathVariable String frequency) {
        List<FlightDto> flights = flightClient.getFlightsByFrequency(frequency);
        if (flights.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);
    }
}
