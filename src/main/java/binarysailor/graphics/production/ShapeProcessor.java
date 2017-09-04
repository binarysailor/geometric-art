package binarysailor.graphics.production;

import binarysailor.graphics.shapes.Circle;
import binarysailor.graphics.shapes.Rectangle;
import binarysailor.graphics.shapes.Shape;

public interface ShapeProcessor {
    Shape process(Shape shape);
    Shape process(Circle circle);
    Shape process(Rectangle rectangle);
}
