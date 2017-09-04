package binarysailor.graphics.production;

import binarysailor.graphics.shapes.Shape;

public interface ShapeFactory {
    Shape createShape(ShapeSpecification specification);
}
