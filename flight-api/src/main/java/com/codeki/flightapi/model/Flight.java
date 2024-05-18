package com.codeki.flightapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    private String destiny;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;
    private String frequency;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Flight(String origin, String destiny, LocalDateTime departureTime, LocalDateTime arrivalTime, double price, String frequency, Company company){
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.frequency = frequency;
        this.company = company;
    }
}
