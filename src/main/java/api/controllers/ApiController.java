package api.controllers;

import api.exceptions.ArgumentNotValidException;

public class ApiController {

    protected void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
