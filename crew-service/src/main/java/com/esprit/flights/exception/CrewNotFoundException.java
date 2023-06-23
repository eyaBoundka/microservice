package com.esprit.crew.exception;
import java.util.UUID;


public class CrewNotFoundException extends Throwable {
    public CrewNotFoundException(UUID id) {
        super("Cannot found crew number [" + id + "]");
    }
}
