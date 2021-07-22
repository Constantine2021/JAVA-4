package com.animals;

public class Puppy extends Dog{

    public Puppy(){
        super();
    }

    public Puppy(int age){
        super();
        if (age > 12 || age < 1){
            throw new ExceptionInInitializerError("Age must be between 1 and 12");
        }
        else{
            super.setAge(age);
        }
    }

    public Puppy(int age, String name){
        super(age, name);
    }

    @Override
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
    public String toString(){
        return String.valueOf(getAge()).concat(" years old Puppy named Anon");
    }


}
