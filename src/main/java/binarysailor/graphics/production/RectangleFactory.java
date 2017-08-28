package binarysailor.graphics.production;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.shapes.Rectangle;


public class RectangleFactory implements ShapeFactory {

    @Override
    public Drawable createShape(ShapeSpecification specification) {
        Size size = specification.getSize();
        return new Rectangle(
                specification.getLocation(), 
                size.getWidth(), size.getHeight(), 
                specification.getRotation(), 
                specification.getColour());
    }

}
