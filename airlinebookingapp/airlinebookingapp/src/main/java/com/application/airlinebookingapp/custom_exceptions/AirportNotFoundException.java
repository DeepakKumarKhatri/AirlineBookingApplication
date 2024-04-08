package com.application.airlinebookingapp.custom_exceptions;

public class AirportNotFoundException extends RuntimeException{
    public AirportNotFoundException(String message) {
        super(message);
    }
}
