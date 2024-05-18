package com.codeki.flightapi.service;

import com.codeki.flightapi.exceptions.ResourceNotFoundException;
import com.codeki.flightapi.model.Company;
import com.codeki.flightapi.model.Dolar;
import com.codeki.flightapi.model.Flight;
import com.codeki.flightapi.model.FlightDto;
import com.codeki.flightapi.repository.CompanyRepository;
import com.codeki.flightapi.repository.FlightRepository;
import com.codeki.flightapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    FlightUtils flightUtils;

    public List<FlightDto> getAllFlights(){
        List<Flight> flightList = flightRepository.findAll();
        return flightUtils.flightListMapperDto(flightList, getDolar());
    }

    public Optional<Flight> findById(Long id){
        return flightRepository.findById(id);
    }

    public List<Flight> getSaleFlights(Integer offerPrice){
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffers(flights, offerPrice);
    }

    public List<Flight> getByOriginAndDestiny(String origin, String destiny){
        return flightRepository.findByOriginAndDestiny(origin, destiny);
    }

    public List<Flight> getByOrigin(String origin){
        return flightRepository.findByOrigin(origin);
    }

    public double getDolar(){
        Dolar dolar = flightUtils.fetchDolar();
        return dolar.getPromedio();
    }

    public Flight createFlight(Flight flight, Long companyId){
        Company company = companyRepository.findById(companyId).orElseThrow(()-> new IllegalArgumentException("Company Not Found"));
        flight.setCompany(company);
        return flightRepository.save(flight);
    }

    public Optional<Flight> updateFlight(Flight flight){
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId());
    }

    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }
}
