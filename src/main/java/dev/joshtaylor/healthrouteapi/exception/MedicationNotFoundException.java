package dev.joshtaylor.healthrouteapi.exception;

public class MedicationNotFoundException extends RuntimeException {

    public MedicationNotFoundException (Long medicationId) {

        super("Could not find " + "medication" + medicationId);
    }
}
