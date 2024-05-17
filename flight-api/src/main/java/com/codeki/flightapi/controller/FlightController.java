package com.codeki.flightapi.controller;

import com.codeki.flightapi.model.Flight;
import com.codeki.flightapi.model.FlightDto;
import com.codeki.flightapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    @CrossOrigin
    @GetMapping("")
    public List<FlightDto> getAllFlights(){
        return flightService.getAllFlights();
    }

    @PostMapping("/add")
    public Flight createFlight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.createFlight(flight, companyId);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @GetMapping("/sale")
    public List<Flight> saleFlights(@RequestParam Integer offerPrice){
        return flightService.getSaleFlights(offerPrice);
    }

    @GetMapping("/locations")
    public List<Flight> getFlightsByLocations(@RequestParam String origin, @RequestParam String destiny){
        return flightService.getByOriginAndDestiny(origin, destiny);
    }

    @GetMapping("/origin")
    public  List<Flight> getFlightsByLocations(@RequestParam String origin){
        return flightService.getByOrigin(origin);
    }

    @GetMapping("/dolarprice")
    public double getDolar(){
        return flightService.getDolar();
    }

    @PostMapping("/add/{companyId}")
    public Flight createFlight(@PathVariable Long companyId, @RequestBody Flight flight){
        return flightService.createFlight(flight, companyId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

    @PutMapping("/update")
    public  Optional<Flight> updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }
}
