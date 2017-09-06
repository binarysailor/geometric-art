package binarysailor.shapeshower.grid;

import java.util.Iterator;

class EqualSizedCellIterator implements Iterator<GridCell> {

    private final EqualSizedCellGrid grid;
    private final int countX, countY;
    private int nextX, nextY;
    private boolean finished;

    EqualSizedCellIterator(EqualSizedCellGrid grid) {
        this.grid = grid;
        this.countX = grid.getCellCountX();
        this.countY = grid.getCellCountY();
    }

    @Override
    public boolean hasNext() {
        return !finished;
    }

    @Override
    public GridCell next() {
        if (finished) {
            throw new IllegalStateException("There is no next cell");
        }

        GridCell result = createCell(nextX, nextY);

        int newx = (nextX + 1) % countX;
        int newy = nextY;
        if (newx == 0) {
            newy++;
        }
        if (newy < countY) {
            nextX = newx;
            nextY = newy;
        } else {
            nextX = 0;
            nextY = 0;
            finished = true;
        }

        return result;
    }

    private GridCell createCell(int x, int y) {
        int left = grid.getOffsetX() + x*grid.getCellWidth();
        int top = grid.getOffsetY() + y*grid.getCellHeight();
        return new GridCell(x, y, left, top, grid.getCellWidth(), grid.getCellHeight());
    }
}
