package com.application.airlinebookingapp.custom_exceptions;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String message){
        super(message);
    }
}
