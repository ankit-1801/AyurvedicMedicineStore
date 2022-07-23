package com.ayurvedamedicine.exception;

public class MedicineNotFoundException extends RuntimeException{
    public MedicineNotFoundException(String message) {
        super(message);
    }

    public MedicineNotFoundException(){

        super("Medicine with this id not found");
    }
}
