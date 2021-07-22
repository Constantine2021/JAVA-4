package com.animals;

import java.util.Objects;

public class Dog extends Animal {
    String name;

    public Dog(){
        super();
        this.name = "Anon";
    }

    public Dog(int age){
        super(age);
        this.name = "Anon";
    }

    public Dog(int age, String name){
        super(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void voice(){
        System.out.println(name + " has barked");
    }

    @Override
    public void jump(){
        System.out.println(name + " has jumped");
    }

    @Override
    public void bite(){
        System.out.println(name + " has bitten");
    }

    @Override
    public void run(){
        System.out.println(name + " has ran");
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }

        if (obj.getClass() != this.getClass()){
            return false;
        }

        Dog comparingDog = (Dog) obj;

        return (comparingDog.getAge() == this.getAge() && comparingDog.getName().equals(this.getName()));
    }

    @Override
    public String toString(){
        return String.valueOf(super.getAge()).concat(" years old Dog named " + this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }


}
