package binarysailor.graphics.production;

import binarysailor.graphics.shapes.Rectangle;
import binarysailor.graphics.shapes.Shape;


public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape createShape(ShapeSpecification s) {
        return new Rectangle(s.getGridCell(), s.getSizeFactor(), s.getOffsetFactorX(), s.getOffsetFactorY(), s.getRotation(), s.getColors(), 1.0);
    }

}
