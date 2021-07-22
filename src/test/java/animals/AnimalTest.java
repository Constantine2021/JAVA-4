package animals;

import com.animals.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    private Animal animal = new Animal();
    private Animal animalNotEqual = new Animal(10);
    private Animal animalEqual = new Animal(5);
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void equalityTest(){
        logger.info("Puppy test for method equals()");
        animal.setAge(5);
        Assertions.assertFalse(animal.equals(animalNotEqual));
        Assertions.assertTrue(animal.equals(animalEqual));
    }

    @Test
    public void toStringTest(){
        logger.info("Animal test for method toString()");
        String toStringrResult = animal.toString();
        String expectedResult = new String(
                "0 years old Animal"
        );
        Assertions.assertEquals(expectedResult, toStringrResult);
    }

    @Test
    public void hashCodeTest(){
        logger.info("Animal test for method hashCode()");
        Animal objectSameHash = new Animal();
        Assertions.assertEquals(animal.hashCode(), objectSameHash.hashCode());
    }

}
