package com.codeki.ticketapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureDateTime;
    private String arrivalDateTime;
    private double convertedPrice;
    private String frecuency;
}
