package com.application.airlinebookingapp.custom_exceptions;

public class AircraftNotFoundException extends RuntimeException{
    public AircraftNotFoundException(String message) {
        super(message);
    }
}
