package binarysailor.shapeshower.grid;

import binarysailor.shapeshower.Location;

public class GridCell {
    private final int x, y, width, height;
    private final Location topLeft, centre;

    GridCell(int x, int y, int left, int top, int cellWidth, int cellHeight) {
        this.x = x;
        this.y = y;
        this.width = cellWidth;
        this.height = cellHeight;
        this.topLeft = new Location(left, top);
        this.centre = topLeft.translate(cellWidth/2, cellHeight/2);
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSmallerSidePx() {
        return Math.min(getWidth(), getHeight());
    }

    public Location getTopLeft() {
        return topLeft;
    }

    public Location getCentre() {
        return centre;
    }

    @Override
    public String toString() {
        return String.format("Cell at (%d, %d) with size %d x %d", x, y, width, height);
    }
}
