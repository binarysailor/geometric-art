package binarysailor.graphics.production;

public class Grid {

    private final int cellCountX, cellCountY;
    private final int cellWidth, cellHeight;

    public Grid(int cellCountX, int cellCountY, int canvasWidth, int canvasHeight) {
        this.cellCountX = cellCountX;
        this.cellCountY = cellCountY;
        this.cellWidth = (int) Math.round((double) canvasWidth / cellCountX);
        this.cellHeight = (int) Math.round((double) canvasHeight / cellCountY);
    }

    public int getCellCountX() {
        return cellCountX;
    }

    public int getCellCountY() {
        return cellCountY;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public GridCell createCell(int x, int y) {
        return new GridCell(this, x, y);
    }
}
