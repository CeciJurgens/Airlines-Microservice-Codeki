package com.codeki.planeapi.service;

import com.codeki.planeapi.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneService {
    @Autowired
    FlightClient flightClient;

    private final List<Plane> planes = new ArrayList<>();

    public List<Plane> getAllPlanes() {
        return planes;
    }

    public Plane createPlane(Plane plane) {
        planes.add(plane);
        return plane;
    }
}
