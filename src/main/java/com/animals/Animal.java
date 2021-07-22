package com.animals;

import java.util.Objects;

public class Animal {
    private int age;

    public Animal(){
        age = 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(int age) {
        try{
            if (age < 0){
                throw new Exception("Age can't be negative");
            }
            else{
                this.age = age;
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void jump(){
        System.out.println("Animal has jumped");
    }

    public void bite(){
        System.out.println("Animal has bitten");
    }

    public void run(){
        System.out.println("Animal has ran");
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }

        if (obj.getClass() != this.getClass()){
            return false;
        }

        Animal comparingAnimal = (Animal) obj;

        return comparingAnimal.getAge() == this.getAge();
    }

    @Override
    public String toString(){
        return String.valueOf(age).concat(" years old Animal");
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
