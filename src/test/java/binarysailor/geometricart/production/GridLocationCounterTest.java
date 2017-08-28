package binarysailor.geometricart.production;

import binarysailor.graphics.production.GridLocationCounter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GridLocationCounterTest {

    @Test(dataProvider = "gridLocations")
    public void shouldProperlyMaintainLocation(int gridWidth, int gridHeight, int count, int expectedX, int expectedY) {
        GridLocationCounter counter = new GridLocationCounter(gridWidth, gridHeight);
        for (int i = 0; i < count; i++) {
            counter.next();
        }
        Assert.assertEquals(counter.getX(), expectedX, "GridLocationCounter X is incorrect");
        Assert.assertEquals(counter.getY(), expectedY, "GridLocationCounter Y is incorrect");
    }

    @Test
    public void shouldThrowExceptionWhenTooManyBumps() {
        GridLocationCounter counter = new GridLocationCounter(5, 3);
        for (int i = 0; i < 5*3; i++) {
            counter.next();
        }
        try {
            counter.getX();
            Assert.fail("Generated the whole grid and still querying. Should throw an exception");
        } catch (IllegalStateException e) {
        }
    }

    @DataProvider(name = "gridLocations")
    public Object[][] provideTestData() {
        return new Integer[][] {
                { 5, 3, 5, 0, 1 }, // 5 by 3; 5 times next yields coordinates (0, 1)
                { 5, 3, 6, 1, 1 },
                { 5, 3, 4, 4, 0 }
        };
    }
}
