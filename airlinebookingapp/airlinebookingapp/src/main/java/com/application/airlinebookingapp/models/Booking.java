package com.application.airlinebookingapp.models;

import jakarta.persistence.*;

import java.io.Serializable;
import jakarta.persistence.Entity;


@Entity
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight; // Rename the attribute to avoid naming conflict

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    public Booking(Long id, Flight flight, Passenger passenger) {
        this.id = id;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }
}
