package com.codeki.planeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    private Long id;
    private FlightDto flight;
    private String passengerName;
    private String passengerEmail;
    private String passengerPassport;
}
