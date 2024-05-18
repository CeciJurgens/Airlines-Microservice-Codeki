package com.codeki.planeapi.service;

import com.codeki.planeapi.model.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ticket-api")
public interface TicketClient {

    @GetMapping("/tickets")
    List<Ticket> getAllTickets();

}
