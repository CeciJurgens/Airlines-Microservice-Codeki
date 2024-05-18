package com.codeki.planeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plane {
    private Long id;
    private FlightDto flightDto;
    private String namePlane;
    private String nameModel;
    private String brand;
    private Integer numberPassenger;
}
