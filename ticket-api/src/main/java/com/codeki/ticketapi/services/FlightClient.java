package com.codeki.ticketapi.services;

import com.codeki.ticketapi.model.CompanyDto;
import com.codeki.ticketapi.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "flight-api")
public interface FlightClient {
    @GetMapping("/flights")
    List<FlightDto> getAllFlights();

    @GetMapping("/flights/dolarprice")
    double getDolar();

    @GetMapping("/flights/{id}")
    Optional<FlightDto> findFlightById();

    @GetMapping("/flights/origin/{origin}")
    List<FlightDto> findFlightsByOrigin(@PathVariable("origin") String origin);

    @GetMapping("/flights/destination/{destination}")
    List<FlightDto> findFlightsByDestination(@PathVariable("destination") String destination);

    @GetMapping("/companies")
    List<CompanyDto> getAllCompanies();

    @GetMapping("/companies/{id}")
    CompanyDto findCompanyById(@PathVariable("id") Long id);

}
