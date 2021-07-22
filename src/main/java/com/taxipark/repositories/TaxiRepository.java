package com.taxipark.repositories;

import com.taxipark.exceptions.CarException;
import com.taxipark.taxi.*;
import com.taxipark.taxi.TaxiPark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaxiRepository {
    private File file = new File("/Users/kosta/IdeaProjects/Laba4/src/main/resources/Taxis.txt");
    private Scanner scanner;
    private static final Logger logger = LogManager.getLogger(TaxiRepository.class.getName());

    public TaxiRepository() {
        try{
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e){
            System.out.println("File wasn't found");
        }
    }

    public TaxiPark readFile() {
        logger.info("Reading file " + file.getName());
        ArrayList<Taxi> taxisFromFile = new ArrayList<>();

        while(scanner.hasNextLine()){
            double price = scanner.nextDouble();
            double speed = scanner.nextDouble();
            double gallonConsume = scanner.nextDouble();
            try{
                Taxi readTaxi = new Taxi(price, speed, gallonConsume);
                taxisFromFile.add(readTaxi);
            }
            catch (CarException e){
                logger.info(e.toString());
            }
        }

        return new TaxiPark(taxisFromFile);
    }
}
