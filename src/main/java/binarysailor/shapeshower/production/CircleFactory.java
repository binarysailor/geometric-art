package binarysailor.shapeshower.production;

import binarysailor.shapeshower.shapes.Circle;
import binarysailor.shapeshower.shapes.Shape;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape(ShapeSpecification s) {
        return new Circle(s.getGridCell(), s.getSizeFactor(), s.getOffsetFactorX(), s.getOffsetFactorY(), s.getRotation(), s.getColors());
    }
}
