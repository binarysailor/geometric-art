package binarysailor.graphics.production;

import binarysailor.graphics.shapes.Location;

public class GridCell {
    private final Grid grid;
    private final int x, y;
    private final Location topLeft, centre;

    GridCell(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.topLeft = new Location(x * grid.getCellWidth(), y * grid.getCellHeight());
        this.centre = topLeft.translate(getWidth()/2, getHeight()/2);
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public int getWidth() {
        return grid.getCellWidth();
    }

    public int getHeight() {
        return grid.getCellHeight();
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
}
