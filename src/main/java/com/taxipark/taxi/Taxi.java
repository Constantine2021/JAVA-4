package com.taxipark.taxi;

import com.taxipark.exceptions.CarException;

import java.io.Serializable;

public class Taxi extends Car implements Serializable {

    public Taxi(){
        super();
    }

    public Taxi(double price, double speed, double gallonConsume) throws CarException {
        super(price, speed, gallonConsume);
    }


    @Override
    public String toString(){
        return "Price: ".concat(String.valueOf(super.getPrice()))
                .concat("\n").concat("Speed: ").concat(String.valueOf(super.getSpeed()))
                .concat("\n").concat("Gallon consumption: ").concat(String.valueOf(super.getGallonConsume()));
    }
}
