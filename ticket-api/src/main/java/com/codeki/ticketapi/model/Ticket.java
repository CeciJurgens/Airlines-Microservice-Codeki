package com.codeki.ticketapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Ticket {

    private Long id;
    private String passengerName;
    private String passengerEmail;
    private String passengerPassport;
    private FlightDto flight;

    public void updateFrom(Ticket other) {
        this.passengerName = other.passengerName;
        this.passengerEmail = other.passengerEmail;
        this.passengerPassport = other.passengerPassport;

    }

}
