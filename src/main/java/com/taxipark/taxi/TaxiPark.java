package com.taxipark.taxi;

import com.taxipark.comparators.SortByGasConsume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class TaxiPark implements Serializable {
    ArrayList<Taxi> taxis = new ArrayList<>();
    public static String department;

    public TaxiPark(Taxi...args){
        taxis.addAll(Arrays.asList(args));
    }

    public TaxiPark(String department, Taxi...args){
        this.department = department;
        taxis.addAll(Arrays.asList(args));
    }

    public TaxiPark(ArrayList<Taxi> taxis){
        this.taxis = (ArrayList<Taxi>) taxis.clone();
    }

    public void printCars(){
        for (Taxi taxi: taxis){
            System.out.println("Taxi №: " + (taxis.indexOf(taxi) + 1));
            System.out.println(taxi.toString());
            System.out.println();
        }
    }

    public double getCost(){
        double cost = 0.;

        for (Taxi taxi: taxis){
            cost += taxi.getPrice();
        }

        return cost;
    }

    public ArrayList<Taxi> getTaxisInSpeedInterval(double speedMin, double speedMax){
        ArrayList<Taxi> list = new ArrayList<>();

        for (Taxi taxi: taxis){
            double speed = taxi.getSpeed();
            if (speed <= speedMax && speed >= speedMin){
                list.add(taxi);
            }
        }

        return list;
    }

    public ArrayList<Taxi> getTaxisInSpeedInterval(double speedMin){
        ArrayList<Taxi> list = new ArrayList<>();

        for (Taxi taxi: taxis){
            double speed = taxi.getSpeed();
            if (speed >= speedMin){
                list.add(taxi);
            }
        }

        return list;
    }

    public ArrayList<Taxi> sortByGallonConsume(){
        ArrayList<Taxi> sorted = (ArrayList<Taxi>) taxis.clone();

        sorted.sort(new SortByGasConsume());

        return sorted;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return taxis.size();
    }

}
