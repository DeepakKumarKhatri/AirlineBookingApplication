package com.application.airlinebookingapp.custom_exceptions;

public class PilotNotFoundException extends RuntimeException{
    public PilotNotFoundException(String message) {
        super(message);
    }
}
