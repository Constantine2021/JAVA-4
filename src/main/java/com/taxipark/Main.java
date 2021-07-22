package com.taxipark;
import com.taxipark.menu.Menu;

import com.taxipark.connectors.Serializer;
import com.taxipark.repositories.TaxiRepository;
import com.taxipark.taxi.TaxiPark;

import java.io.InvalidObjectException;

public class Main {  //lab9
    /*public static void main(String[] args) {
        TaxiRepository taxiRepository = new TaxiRepository();
        TaxiPark taxiPark = taxiRepository.readFile();
        String fileName = "/Users/kosta/IdeaProjects/Laba4/src/main/resources/serialize.txt";
        TaxiPark.department = "FFFF";
        Serializer.serialize(taxiPark, fileName);
        try{
            TaxiPark taxiPark1 = (TaxiPark) Serializer.deserialize(fileName);
            taxiPark1.printCars();
        }
        catch (InvalidObjectException e){
            System.out.println(e.toString());
        }
    }*/

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
