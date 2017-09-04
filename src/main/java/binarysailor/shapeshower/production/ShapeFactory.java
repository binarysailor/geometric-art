package binarysailor.shapeshower.production;

import binarysailor.shapeshower.shapes.Shape;

public interface ShapeFactory {
    Shape createShape(ShapeSpecification specification);
}
