package binarysailor.graphics.production;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import binarysailor.graphics.shapes.Shape;

public class ShapeProductionPipeline {

    private List<ShapeProcessor> processors = new LinkedList<>();
    private ShapeFactory shapeFactory;
    private Grid grid;
    private GridLocationCounter locationCounter;

    public ShapeProductionPipeline(final ShapeFactory shapeFactory, final Grid grid) {
        this.shapeFactory = shapeFactory;
        this.grid = grid;
        this.locationCounter = new GridLocationCounter(grid.getCellCountX(), grid.getCellCountY());
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

    private ShapeSpecification createSpecification() {
        try {
            GridCell cell = grid.createCell(locationCounter.getX(), locationCounter.getY());
            locationCounter.next();
            ShapeSpecification specification = new ShapeSpecification(cell, new Colors(Color.black, Color.black));
            return specification;
        } catch (IllegalStateException e) {
            // the whole grid has been generated
            return null;
        }
    }

}
