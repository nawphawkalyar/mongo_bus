package com.example.busticketmongo.model;

public class Seats {
    private String seatsNumber;
    private SeatStatus seatStatus;

    public Seats(String seatsNumber, SeatStatus seatStatus) {
        this.seatsNumber = seatsNumber;
        this.seatStatus = seatStatus;
    }

    public String getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(String seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
