package com.taxipark.taxi;

import com.taxipark.exceptions.CarException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Objects;

public class Car {
    private transient double price;
    private double speed;
    private double gallonConsume;

    private static final Logger logger = LogManager.getLogger(Car.class.getName());

    public Car(){
        price = 0;
        speed = 0;
        gallonConsume = 0;
    }

    public Car(double price, double speed, double gallonConsume) throws CarException {
        this.price = price;
        checkPrice();

        this.speed = speed;
        checkSpeed();

        this.gallonConsume = gallonConsume;
        checkGallonConsume();

    }

    private void checkPrice() throws CarException {
        if (price < 0){
            throw new CarException("Price cannot be negative", price);
        }
    }

    private void checkSpeed() throws CarException {
        if (speed < 0){
            throw new CarException("Speed cannot be negative", price);
        }
    }

    private void checkGallonConsume() throws CarException {
        if (gallonConsume < 0){
            throw new CarException("Gallon consume cannot be negative", price);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getGallonConsume() {
        return gallonConsume;
    }

    public void setGallonConsume(double gallonConsume) {
        this.gallonConsume = gallonConsume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.getPrice(), getPrice()) == 0 &&
                Double.compare(car.getSpeed(), getSpeed()) == 0 &&
                Double.compare(car.getGallonConsume(), getGallonConsume()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getSpeed(), getGallonConsume());
    }
}
