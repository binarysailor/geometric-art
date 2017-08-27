package binarysailor.graphics.production;

public class GridLocationCounter {
    private final int width, height;
    private int x, y;
    private boolean finished;

    public GridLocationCounter(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public boolean next() {
        int newx = (x + 1) % width;
        int newy = y;
        if (newx == 0) {
            newy++;
        }
        if (newy < height) {
            x = newx;
            y = newy;
            return true;
        } else {
            finished = true;
            return false;
        }
    }

    public int getX() {
        if (finished) {
            throw new IllegalStateException();
        }
        return x;
    }

    public int getY() {
        if (finished) {
            throw new IllegalStateException();
        }
        return y;
    }
}
