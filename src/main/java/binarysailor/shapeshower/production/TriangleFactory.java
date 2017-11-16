package binarysailor.shapeshower.production;

import binarysailor.shapeshower.shapes.Shape;
import binarysailor.shapeshower.shapes.Triangle;

public class TriangleFactory implements ShapeFactory {
    @Override
    public Shape createShape(ShapeSpecification s) {
        return new Triangle(s.getGridCell(), s.getSizeFactor(), s.getOffsetFactorX(), s.getOffsetFactorY(), s.getRotation(), s.getColors());
    }
}
