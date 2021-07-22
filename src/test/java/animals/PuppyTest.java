package animals;

import com.animals.Puppy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuppyTest {
    private Puppy puppy = new Puppy();
    private Puppy puppyNotEqual = new Puppy(1, "Malvina");
    private Puppy puppyEqual = new Puppy(2, "Jojo");
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void equalTest(){
        logger.info("Puppy test for method equals()");
        puppy.setAge(2);
        puppy.setName("Jojo");
        Assertions.assertNotEquals(puppy, puppyNotEqual);
        Assertions.assertEquals(puppy, puppyEqual);
    }

    @Test
    public void toStringTest(){
        logger.info("Puppy test for method toString()");
        String toStringResult = puppy.toString();
        String expectedResult = new String(
                "0 years old Puppy named Anon"
        );
        Assertions.assertEquals(toStringResult, expectedResult);
    }

    @Test
    public void hashCodeTest(){
        logger.info("Puppy test for method hashCode()");
        puppy.setAge(2);
        puppy.setName("Jojo");
        Assertions.assertEquals(puppy.hashCode(), puppyEqual.hashCode());
        Assertions.assertNotEquals(puppy.hashCode(), puppyNotEqual.hashCode());
    }
}
