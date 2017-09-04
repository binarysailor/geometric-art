package binarysailor.graphics.production;

public class ShapeSpecification {

    private double sizeFactor = 1.0;
    private double offsetFactorX = 0.0, offsetFactorY = 0.0;
    private final GridCell gridCell;
    private double rotation = 0.0;
    private final Colors colors;
    private boolean active = true;

    public ShapeSpecification(GridCell gridCell, Colors colors) {
        this.gridCell = gridCell;
        this.colors = colors;
    }

    public double getSizeFactor() {
        return sizeFactor;
    }

    public void setSizeFactor(final double sizeFactor) {
        this.sizeFactor = sizeFactor;
    }

    public GridCell getGridCell() {
        return gridCell;
    }

    public double getRotation() {
        return rotation;
    }

    public double getOffsetFactorX() {
        return offsetFactorX;
    }

    public void setOffsetFactorX(double offsetFactorX) {
        this.offsetFactorX = offsetFactorX;
    }

    public double getOffsetFactorY() {
        return offsetFactorY;
    }

    public void setOffsetFactorY(double offsetFactorY) {
        this.offsetFactorY = offsetFactorY;
    }

    public void setRotation(final double rotation) {
        this.rotation = rotation;
    }

    public Colors getColors() {
        return colors;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
