package binarysailor.shapeshower.processors;

import binarysailor.shapeshower.production.ShapeProcessor;
import binarysailor.shapeshower.shapes.Circle;
import binarysailor.shapeshower.shapes.Rectangle;
import binarysailor.shapeshower.shapes.Shape;

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
