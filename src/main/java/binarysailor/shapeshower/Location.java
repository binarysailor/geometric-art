package binarysailor.shapeshower;

public class Location {
    private int x, y;

    public Location(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Location translate(int dx, int dy) {
        return new Location(x + dx, y + dy);
    }
}
