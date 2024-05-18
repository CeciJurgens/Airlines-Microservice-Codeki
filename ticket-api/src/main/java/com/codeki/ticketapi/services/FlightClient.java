package com.codeki.ticketapi.services;

import com.codeki.ticketapi.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "flight-api")
public interface FlightClient {
    @GetMapping("/flights")
    List<FlightDto> getAllFlights();
}
