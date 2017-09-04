package binarysailor.graphics.production;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import binarysailor.graphics.production.grid.Grid;
import binarysailor.graphics.production.grid.GridCell;
import binarysailor.graphics.shapes.Shape;

public class ShapeProductionPipeline {

    private List<ShapeProcessor> processors = new LinkedList<>();
    private ShapeFactory shapeFactory;
    private Iterator<GridCell> cells;

    public ShapeProductionPipeline(final ShapeFactory shapeFactory, final Grid grid) {
        this.shapeFactory = shapeFactory;
        this.cells = grid.cellIterator();
    }

    public void addProcessor(ShapeProcessor processor) {
        processors.add(processor);
    }

    public Optional<Shape> produce() {

        ShapeSpecification specification = createSpecification();
        Shape shape = null;

        if (specification != null) {
            shape = shapeFactory.createShape(specification);
            if (shape != null) {
                for (ShapeProcessor processor : processors) {
                    shape = shape.accept(processor);
                    if (shape == null) {
                        break;
                    }
                }
            }
        }

        if (shape != null) {
            return Optional.of(shape);
        } else {
            return Optional.empty();
        }
    }

    public Iterable<Shape> produceAll() {
        Collection<Shape> shapes = new LinkedList<>();
        Optional<Shape> shapeOptional;
        do {
            shapeOptional = produce();
            if (shapeOptional.isPresent()) {
                shapes.add(shapeOptional.get());
            }
        } while (shapeOptional.isPresent());

        return shapes;
    }

    private ShapeSpecification createSpecification() {
        if (cells.hasNext()) {
            GridCell cell = cells.next();
            ShapeSpecification specification = new ShapeSpecification(cell, new Colors(Color.black, Color.black));
            return specification;
        } else {
            // the whole grid has been generated
            return null;
        }
    }

}
