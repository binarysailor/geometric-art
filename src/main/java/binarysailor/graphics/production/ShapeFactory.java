package binarysailor.graphics.production;

import binarysailor.graphics.Drawable;

public interface ShapeFactory {
    Drawable createShape(ShapeSpecification specification);
}
