package binarysailor.graphics.production.processors;

import binarysailor.graphics.production.ShapeProcessor;
import binarysailor.graphics.shapes.Circle;
import binarysailor.graphics.shapes.Rectangle;
import binarysailor.graphics.shapes.Shape;

abstract class ShapeProcessorBase implements ShapeProcessor {

    @Override
    public Shape process(Circle circle) {
        return process((Shape)circle);
    }

    @Override
    public Shape process(Rectangle rectangle) {
        return process((Shape)rectangle);
    }

}
