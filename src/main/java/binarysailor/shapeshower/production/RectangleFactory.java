package binarysailor.shapeshower.production;

import binarysailor.shapeshower.shapes.Rectangle;
import binarysailor.shapeshower.shapes.Shape;


public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape createShape(ShapeSpecification s) {
        return new Rectangle(s.getGridCell(), s.getSizeFactor(), s.getOffsetFactorX(), s.getOffsetFactorY(), s.getRotation(), s.getColors(), 1.0);
    }

}
