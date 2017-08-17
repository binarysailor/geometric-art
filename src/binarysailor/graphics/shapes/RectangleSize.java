package binarysailor.graphics.shapes;

public class RectangleSize implements Size {
    private int width, height;

    public RectangleSize(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Size scale(final double factor) {
        return new RectangleSize((int)(width * factor), (int)(height * factor));
    }
}
