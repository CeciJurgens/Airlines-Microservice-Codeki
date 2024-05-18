package com.codeki.planeapi.service;

import com.codeki.planeapi.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "flight-api")
public interface FlightClient {
    @GetMapping("/flight")
    List<FlightDto> getAllFlights();

    @GetMapping("/dolarprice")
    double getDolar();

    @GetMapping("/flight/{id}")
    Optional<FlightDto> findFlightById();
}
