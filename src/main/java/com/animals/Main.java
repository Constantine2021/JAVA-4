package com.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*
10. Создать объект класса Щенок, используя классы Животное, Собака.
Методы: вывести на консоль имя, подать голос, прыгать, бегать, кусать.

10. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. Подсчитать стоимость автопарка. Провести сортировку автомобилей
парка по расходу топлива. Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("Proceeding main...");
        Animal animal = new Animal(2);
        Dog doggy = new Dog(5, "Fluffy");
        Puppy puppy = new Puppy(2, "Jojo");

        animal.run();
        animal.bite();
        animal.jump();
        System.out.println();
        doggy.run();
        doggy.bite();
        doggy.jump();
        doggy.voice();
        System.out.println();
        puppy.run();
        puppy.bite();
        puppy.jump();
        puppy.voice();

        Animal animalWithException = new Animal(-1);

        logger.info("Main have finished it work...");
    }

}
