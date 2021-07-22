package taxipark;

import com.taxipark.taxi.Taxi;
import com.taxipark.taxi.TaxiPark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TaxiParkTest {

    private Taxi taxi1 = new Taxi(3000, 120, 10);
    private Taxi taxi2 = new Taxi(5000, 200, 15);
    private Taxi taxi3 = new Taxi(2000, 100, 20);
    private Taxi taxi4 = new Taxi(3500, 150, 12);

    private TaxiPark taxiPark = new TaxiPark(taxi1, taxi2, taxi3, taxi4);

    public TaxiParkTest() throws Exception {
    }

    @Test
    public void printTest(){
        taxiPark.printCars();
    }

    @Test
    public void taxiParkCostTest(){
        double expectedCost = 13500;
        Assertions.assertEquals(expectedCost, taxiPark.getCost());
    }

    @Test
    public void speedIntervalTest(){
        ArrayList<Taxi> taxiInSpeedInterval = taxiPark.getTaxisInSpeedInterval(120, 150);
        Assertions.assertEquals(2, taxiInSpeedInterval.size());

        taxiInSpeedInterval = taxiPark.getTaxisInSpeedInterval(120);
        Assertions.assertEquals(3, taxiInSpeedInterval.size());
    }

    @Test void sortByGallonConsume(){
        ArrayList<Taxi> sortedList = taxiPark.sortByGallonConsume();
        ArrayList<Taxi> expectedList = new ArrayList<>();
        expectedList.add(taxi1);
        expectedList.add(taxi4);
        expectedList.add(taxi2);
        expectedList.add(taxi3);

        Assertions.assertEquals(expectedList, sortedList);
    }
}
