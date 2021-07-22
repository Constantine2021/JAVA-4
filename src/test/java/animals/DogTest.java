package animals;

import com.animals.Dog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogTest {
    private Dog dog = new Dog();
    private Dog dogNotEqual = new Dog(5, "Dora");
    private Dog dogEqual = new Dog(2, "Fluffy");
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void equalTest(){
        logger.info("Dog test for method equals()");
        Assertions.assertFalse(dog.equals(dogNotEqual));
        dog.setName("Fluffy");
        dog.setAge(2);
        Assertions.assertTrue(dog.equals(dogEqual));
    }

    @Test
    public void toStringTest(){
        logger.info("Dog test for method toString()");
        String expected = new String("0 years old Dog named Anon");
        Assertions.assertEquals(dog.toString(), expected);
    }

    @Test
    public void hashCodeTest(){
        logger.info("Dog test for method hashCode()");
        dog.setName("Fluffy");
        dog.setAge(2);
        Assertions.assertEquals(dog.hashCode(), dogEqual.hashCode());
        Assertions.assertNotEquals(dog.hashCode(), dogNotEqual.hashCode());
    }
}
