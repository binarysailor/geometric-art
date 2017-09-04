package binarysailor.graphics.shapes;

import java.awt.Graphics2D;

import binarysailor.graphics.Image;
import binarysailor.graphics.production.Colors;
import binarysailor.graphics.production.GridCell;

public abstract class ShapeBase implements Shape {

    private GridCell cell;
    private boolean active = true;
    private double sizeFactor;
    private double xOffsetFactor, yOffsetFactor;
    private double rotation;
    private Colors colors;

    public ShapeBase(GridCell cell, double sizeFactor, double xOffsetFactor, double yOffsetFactor, double rotation, Colors colors) {
        this.cell = cell;
        this.sizeFactor = sizeFactor;
        this.xOffsetFactor = xOffsetFactor;
        this.yOffsetFactor = yOffsetFactor;
        this.rotation = rotation;
        this.colors = colors;
    }

    @Override
    public void draw(Image target) {
        java.awt.Shape shape = createShape();
        Location centre = getCell().getCentre();

        Graphics2D graphics = target.getGraphics();
        if (rotation != 0) {
            graphics.rotate(rotation, centre.x(), centre.y());
        }
        graphics.setColor(colors.getPaintColor());
        graphics.fill(shape);
        graphics.setColor(colors.getOutlineColor());
        graphics.draw(shape);
        if (rotation != 0) {
            graphics.rotate(-rotation, centre.x(), centre.y());
        }
    }

    @Override
    public GridCell getCell() {
        return cell;
    }

    @Override
    public double getSizeFactor() {
        return sizeFactor;
    }

    @Override
    public void setSizeFactor(double sizeFactor) {
        this.sizeFactor = sizeFactor;
    }

    @Override
    public double getXOffsetFactor() {
        return xOffsetFactor;
    }

    @Override
    public void setXOffsetFactor(double xOffsetFactor) {
        this.xOffsetFactor = xOffsetFactor;
    }

    @Override
    public double getYOffsetFactor() {
        return yOffsetFactor;
    }

    @Override
    public void setYOffsetFactor(double yOffsetFactor) {
        this.yOffsetFactor = yOffsetFactor;
    }

    @Override
    public double getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    protected void setyOffsetFactor(double yOffsetFactor) {
        this.yOffsetFactor = yOffsetFactor;
    }

    protected void setColors(Colors colors) {
        this.colors = colors;
    }

    @Override
    public Colors getColors() {
        return colors;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    abstract protected java.awt.Shape createShape();
}
