package com.taxipark.menu;

import com.taxipark.taxi.*;
import com.taxipark.taxi.TaxiPark;
import com.taxipark.repositories.TaxiRepository;
import com.taxipark.validators.UserInputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private TaxiPark taxiPark;
    private Scanner scanner = new Scanner(System.in);
    private boolean stopMenu = false;
    private UserInputValidator validator = new UserInputValidator();

    public Menu(){
        TaxiRepository taxiRepository = new TaxiRepository();
        taxiPark = taxiRepository.readFile();;
    }

    public Menu(TaxiPark taxiPark){
        this.taxiPark = taxiPark;
    }

    public void run(){
        while (!stopMenu){
            showMenu();
            int choice = validator.checkUserChoice(scanner);
            switch (choice){
                case 1:
                    showTaxis();
                    break;
                case 2:
                    sortByGallonConsumingAndShow();
                    break;
                case 3:
                    showTaxisInSpeedInterval();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("There is no such choice as " + choice);
            }
        }
    }

    public void showMenu(){
        StringBuilder s = new StringBuilder();

        s.append("Choose the action").append("\n")
                .append("1.Show taxis").append("\n")
                .append("2.Sort by gallon consuming").append("\n")
                .append("3.Show taxis in speed interval").append("\n")
                .append("0.Exit programm").append("\n")
                .append(">>> ");

        System.out.print(s.toString());
    }

    public void showTaxis(){
        if (!taxiPark.isEmpty()){
            taxiPark.printCars();
        }
        else{
            System.out.println("Taxi park is empty");
        }
    }

    public void sortByGallonConsumingAndShow(){
        ArrayList<Taxi> sorted = taxiPark.sortByGallonConsume();
        TaxiPark sortedTaxiPark = new TaxiPark(sorted);
        sortedTaxiPark.printCars();
    }

    public void showTaxisInSpeedInterval(){
        System.out.print("What is min speed: ");
        int minSpeed = validator.checkInputSpeed(scanner);

        System.out.print("What is max speed: ");
        int maxSpeed = validator.checkInputSpeed(scanner);

        ArrayList<Taxi> taxisInSpeedInterval = taxiPark.getTaxisInSpeedInterval(minSpeed, maxSpeed);
        TaxiPark taxiParkInSpeedInterval = new TaxiPark(taxisInSpeedInterval);

        taxiParkInSpeedInterval.printCars();
    }

    public void exit(){
        System.out.println("Stopping application...");
        stopMenu = true;
    }

}
