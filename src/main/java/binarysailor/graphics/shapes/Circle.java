package binarysailor.graphics.shapes;

import java.awt.geom.Ellipse2D;

import binarysailor.graphics.production.Colors;
import binarysailor.graphics.production.GridCell;
import binarysailor.graphics.production.ShapeProcessor;

public class Circle extends ShapeBase {

    public Circle(GridCell cell, double sizeFactor, double xOffsetFactor, double yOffsetFactor, double angle, Colors colors) {
        super(cell, sizeFactor, xOffsetFactor, yOffsetFactor,angle, colors);
    }

    @Override
    protected java.awt.Shape createShape() {
        GridCell cell = getCell();
        Location cellCentre = cell.getCentre();
        double sizeFactor = getSizeFactor();
        double left = cellCentre.x() - sizeFactor * cell.getWidth() / 2;
        double top = cellCentre.y() - sizeFactor * cell.getHeight() / 2;
        return new Ellipse2D.Double(left, top, sizeFactor*cell.getWidth(), sizeFactor*cell.getHeight());
    }

    @Override
    public Shape accept(ShapeProcessor processor) {
        return processor.process(this);
    }
}
