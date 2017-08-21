package binarysailor.graphics.shapes;

public class CircleSize implements Size {
    private int r;

    public CircleSize(final int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    @Override
    public Size scale(final double factor) {
        return new CircleSize((int)(r * factor));
    }
}
