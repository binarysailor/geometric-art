package binarysailor.shapeshower.production;

import binarysailor.shapeshower.shapes.Circle;
import binarysailor.shapeshower.shapes.Rectangle;
import binarysailor.shapeshower.shapes.Shape;

public interface ShapeProcessor {
    Shape process(Shape shape);
    Shape process(Circle circle);
    Shape process(Rectangle rectangle);
}
