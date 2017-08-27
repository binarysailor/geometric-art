package binarysailor.graphics.production;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.shapes.Circle;
import binarysailor.graphics.shapes.Location;

public class CircleFactory implements ShapeFactory {
    @Override
    public Drawable createShape(final ShapeSpecification specification) {
        Size size = specification.getSize();
        int diameter = Math.min(size.getWidth(), size.getHeight());
        Location topLeft = specification.getLocation();

        return new Circle(
                specification.getColour(),
                diameter / 2,
                topLeft.translate(size.getWidth() / 2, size.getHeight() / 2));
    }
}
