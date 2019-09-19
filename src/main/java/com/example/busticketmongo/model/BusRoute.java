package com.example.busticketmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
@Document(collection = "busroute")
public class BusRoute {
    @Id
    private String id;
    private Bus bus;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Routes routes;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    @Field("bustop")
    private List<String> busStop;

    public BusRoute(Bus bus, Routes routes, LocalDateTime departureTime, LocalDateTime arrivalTime, List<String> busStop) {
        this.bus = bus;
        this.routes = routes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busStop = busStop;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<String> getBusStop() {
        return busStop;
    }

    public void setBusStop(List<String> busStop) {
        this.busStop = busStop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
