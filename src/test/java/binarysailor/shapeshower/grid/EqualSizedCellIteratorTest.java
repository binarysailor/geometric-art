package binarysailor.shapeshower.grid;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import binarysailor.shapeshower.grid.EqualSizedCellGrid;
import binarysailor.shapeshower.grid.EqualSizedCellIterator;
import binarysailor.shapeshower.grid.GridCell;

public class EqualSizedCellIteratorTest {

    @Test(dataProvider = "gridLocations")
    public void shouldProperlyTrackLocation(int gridWidth, int gridHeight, int count, int expectedX, int expectedY) {
        EqualSizedCellGrid grid = new EqualSizedCellGrid(gridWidth, gridHeight, 0, 0, 0, 0);
        EqualSizedCellIterator cells = new EqualSizedCellIterator(grid);

        GridCell cell = null;
        for (int i = 0; i < count; i++) {
            cell = cells.next();
        }
        Assert.assertEquals(cell.getPositionX(), expectedX, "cell X is incorrect");
        Assert.assertEquals(cell.getPositionY(), expectedY, "cell Y is incorrect");
    }

    @Test
    public void shouldThrowExceptionWhenTooManyBumps() {
        EqualSizedCellGrid grid = new EqualSizedCellGrid(5, 3, 0, 0, 0, 0);
        EqualSizedCellIterator cells = new EqualSizedCellIterator(grid);
        for (int i = 0; i < 5*3; i++) {
            cells.next();
        }

        Assert.assertFalse(cells.hasNext());
        try {
            cells.next();
            Assert.fail("Generated the whole grid and still querying. Should return null");
        } catch (IllegalStateException e) {
            // expected
        }
    }

    @DataProvider(name = "gridLocations")
    public Object[][] provideTestData() {
        return new Integer[][] {
                { 5, 3, 5, 4, 0 }, // 5 by 3; 5 times next yields coordinates (4, 0)
                { 5, 3, 6, 0, 1 },
                { 5, 3, 4, 3, 0 }
        };
    }
}
