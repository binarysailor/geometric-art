package binarysailor.shapeshower.production;

import java.awt.Composite;

import binarysailor.shapeshower.shapes.Shape;

public class Layer {

    private Iterable<Shape> shapes;
    private Composite composite;

    public Layer(Iterable<Shape> shapes, Composite composite) {
        this.shapes = shapes;
        this.composite = composite;
    }

    public Iterable<Shape> getShapes() {
        return shapes;
    }

    public Composite getComposite() {
        return composite;
    }

}
