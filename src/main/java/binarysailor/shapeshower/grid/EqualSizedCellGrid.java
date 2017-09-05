package binarysailor.shapeshower.grid;

import java.util.Iterator;

public class EqualSizedCellGrid implements Grid {

    private final int xOffset, yOffset;
    private final int cellCountX, cellCountY;
    private final int cellWidth, cellHeight;

    public EqualSizedCellGrid(int cellCountX, int cellCountY, int canvasWidth, int canvasHeight, int offsetX, int offsetY) {
        this.cellCountX = cellCountX;
        this.cellCountY = cellCountY;
        this.cellWidth = canvasWidth / cellCountX;
        this.cellHeight = canvasHeight / cellCountY;
        this.xOffset = offsetX;
        this.yOffset = offsetY;
    }

    int getCellCountX() {
        return cellCountX;
    }

    int getCellCountY() {
        return cellCountY;
    }

    int getCellWidth() {
        return cellWidth;
    }

    int getCellHeight() {
        return cellHeight;
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getYOffset() {
        return yOffset;
    }

    public Iterator<GridCell> cellIterator() {
        return new EqualSizedCellIterator(this);
    }
}
