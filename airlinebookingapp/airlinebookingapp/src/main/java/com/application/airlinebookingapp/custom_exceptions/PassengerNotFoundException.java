package com.application.airlinebookingapp.custom_exceptions;

public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(String message) {
        super(message);
    }
}
