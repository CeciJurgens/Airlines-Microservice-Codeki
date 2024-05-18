package com.codeki.flightapi.utils;

import com.codeki.flightapi.model.Dolar;
import com.codeki.flightapi.model.Flight;
import com.codeki.flightapi.model.FlightDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {

    @Value("${dolarapi.url:}")
    private String URL_DOLAR;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public FlightDto flightMapper(Flight flight, Double dolar){
        return new FlightDto(flight.getId(), flight.getOrigin(), flight.getDestiny(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getPrice()* dolar, flight.getFrequency(), flight.getCompany() );
    }

    public List<FlightDto> flightListMapperDto(List<Flight> flightsList, double dolar){
        return flightsList.stream().map(flight-> flightMapper(flight, dolar)).collect(Collectors.toList());
    }

    public List<Flight> detectOffers(List<Flight> flights, double offerPrice){
        return flights.stream().filter(flightDto->flightDto.getPrice() < offerPrice).collect(Collectors.toList());
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        return restTemplate.getForObject(URL_DOLAR, Dolar.class);
    }
/*
    public Dolar[] fetchAllDolars(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares";
        return restTemplate.getForEntity(apiUrl, Dolar[].class).getBody();
    }

 */
}
