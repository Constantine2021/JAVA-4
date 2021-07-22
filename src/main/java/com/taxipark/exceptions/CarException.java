package com.taxipark.exceptions;

public class CarException extends Exception{
    double value;
    public CarException(String errorMessage, double value){
        super(errorMessage);
        this.value = value;
    }

    @Override
    public String toString() {
        return super.getMessage() + " " + value;
    }
}
