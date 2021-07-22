package com.taxipark.comparators;

import com.taxipark.taxi.Taxi;

import java.util.Comparator;

public class SortByGasConsume implements Comparator<Taxi> {

    public int compare(Taxi a, Taxi b){
        return (int) (a.getGallonConsume() - b.getGallonConsume());
    }
}
