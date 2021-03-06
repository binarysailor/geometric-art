package binarysailor.shapeshower.production;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import binarysailor.shapeshower.Colors;
import binarysailor.shapeshower.grid.Grid;
import binarysailor.shapeshower.grid.GridCell;
import binarysailor.shapeshower.shapes.*;

public class ShapeProductionPipeline {

    private List<ShapeProcessor> processors = new LinkedList<>();
    private ShapeFactory shapeFactory;
    private Grid grid;
    private Iterator<GridCell> cells;

    public ShapeProductionPipeline(final ShapeFactory shapeFactory, final Grid grid) {
        this.shapeFactory = shapeFactory;
        this.grid = grid;
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
                    shape = shape.accept(new ShapeVisitorAdapter(processor));
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
        reset();
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

    private void reset() {
        cells = grid.cellIterator();
    }

    private ShapeSpecification createSpecification() {
        assertCellsInitialized();
        if (cells.hasNext()) {
            GridCell cell = cells.next();
            ShapeSpecification specification = new ShapeSpecification(cell, new Colors(Color.black, Color.black));
            return specification;
        } else {
            // the whole grid has been generated
            return null;
        }
    }

    private void assertCellsInitialized() {
        if (cells == null) {
            cells = grid.cellIterator();
        }
    }

    private class ShapeVisitorAdapter implements ShapeVisitor {

        private ShapeProcessor processor;

        public ShapeVisitorAdapter(ShapeProcessor processor) {
            this.processor = processor;
        }

        @Override
        public Shape visit(Shape shape) {
            return processor.process(shape);
        }

        @Override
        public Shape visit(Rectangle rectangle) {
            return processor.process(rectangle);
        }

        @Override
        public Shape visit(Circle circle) {
            return processor.process(circle);
        }

        @Override
        public Shape visit(final Triangle triangle) {
            return processor.process(triangle);
        }
    }
}
