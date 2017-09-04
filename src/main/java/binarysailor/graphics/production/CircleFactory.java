package binarysailor.graphics.production;

import binarysailor.graphics.shapes.Circle;
import binarysailor.graphics.shapes.Shape;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape(ShapeSpecification s) {
        return new Circle(s.getGridCell(), s.getSizeFactor(), s.getOffsetFactorX(), s.getOffsetFactorY(), s.getRotation(), s.getColors());
    }
}
