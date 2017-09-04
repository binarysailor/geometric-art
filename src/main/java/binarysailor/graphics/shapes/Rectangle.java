package binarysailor.graphics.shapes;

import binarysailor.graphics.production.Colors;
import binarysailor.graphics.production.ShapeProcessor;
import binarysailor.graphics.production.grid.GridCell;

public class Rectangle extends ShapeBase {

    private double aspectRatio; // width / height

    public Rectangle(GridCell cell, double sizeFactor, double xOffsetFactor, double yOffsetFactor, double rotation, Colors colors, double aspectRatio) {
        super(cell, sizeFactor, xOffsetFactor, yOffsetFactor, rotation, colors);
        this.aspectRatio = aspectRatio;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @Override
    protected java.awt.Shape createShape() {
        int cellWidth = getCell().getWidth();
        int cellHeight = getCell().getHeight();
        double width = (int)(cellWidth * getSizeFactor());
        double height = width / aspectRatio;
        int top = getCell().getTopLeft().y() + (int)((cellHeight - height) / 2);
        int left = getCell().getTopLeft().x() + (int)((cellWidth - width) / 2);

        return new java.awt.Rectangle(left, top, (int)width, (int)height);
    }

    @Override
    public Shape accept(ShapeProcessor processor) {
        return processor.process(this);
    }
}
