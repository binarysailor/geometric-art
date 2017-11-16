package binarysailor.shapeshower.shapes;

import binarysailor.shapeshower.Colors;
import binarysailor.shapeshower.grid.GridCell;

import java.awt.*;
import java.awt.Shape;

public class Triangle extends ShapeBase {

    private static final double HEIGHT_TO_BASE_RATIO = Math.sqrt(3) / 2;

    public Triangle(GridCell cell, double sizeFactor, double xOffsetFactor, double yOffsetFactor, double rotation, Colors colors) {
        super(cell, sizeFactor, xOffsetFactor, yOffsetFactor, rotation, colors);
    }

    @Override
    protected Shape createShape() {
        GridCell cell = getCell();
        int side = getCell().getSmallerSidePx();
        int height = calculateHeight(side);
        int topY = cell.getCentre().y() - height/2;
        int baseY = cell.getCentre().y() + height/2;

        java.awt.Polygon triangle = new Polygon();
        triangle.addPoint(cell.getCentre().x(), topY);
        triangle.addPoint(cell.getCentre().x() + side/2, baseY);
        triangle.addPoint(cell.getTopLeft().x(), baseY);

        return triangle;
    }

    private int calculateHeight(int base) {
        return (int)(base * HEIGHT_TO_BASE_RATIO);
    }

    @Override
    public binarysailor.shapeshower.shapes.Shape accept(final ShapeVisitor visitor) {
        return visitor.visit(this);
    }
}
