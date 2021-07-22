package com.taxipark.validators;

import java.util.Scanner;

public class UserInputValidator {
    public int checkUserChoice(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.println("Choice must be an integer");
            System.out.print(">>> ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        return choice;
    }

    public int checkInputSpeed(Scanner scanner){
        int speed;
        do {
            while(!scanner.hasNextInt()){
                System.out.println("Speed must be a positive integer");
                System.out.print(">>> ");
                scanner.next();
            }
            speed = scanner.nextInt();
            if (speed <= 0){
                System.out.println("Speed can't be negative");
                System.out.print(">>> ");
            }
        }while(speed <= 0);


        return speed;
    }
}
