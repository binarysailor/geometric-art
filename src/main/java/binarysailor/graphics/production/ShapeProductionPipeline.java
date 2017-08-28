package binarysailor.graphics.production;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.shapes.Location;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShapeProductionPipeline {

    private List<ShapeSpecificationProcessor> processors = new LinkedList<>();
    private ShapeFactory shapeFactory;
    @SuppressWarnings("unused")
    private int gridWidth, gridHeight;
    private int defaultShapeWidth, defaultShapeHeight;
    private GridLocationCounter locationCounter;

    public ShapeProductionPipeline(final ShapeFactory shapeFactory, final int gridWidth, final int gridHeight, double aspectRatio) {
        this.shapeFactory = shapeFactory;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.locationCounter = new GridLocationCounter(gridWidth, gridHeight);
        this.defaultShapeWidth = aspectRatio >= 1.0 ? 1000 / gridWidth : (int)(1000 * aspectRatio) / gridWidth;
        this.defaultShapeHeight = aspectRatio >= 1.0 ? (int)(1000 / aspectRatio) / gridHeight : 1000 / gridHeight;
    }

    public void addProcessor(ShapeSpecificationProcessor processor) {
        processors.add(processor);
    }

    public Optional<Drawable> produce() {

        ShapeSpecification specification = createSpecification();

        if (specification != null) {
            for (ShapeSpecificationProcessor processor : processors) {
                specification = processor.process(specification);
                if (specification == null) {
                    break;
                }
            }
        }

        if (specification != null) {
            return Optional.of(shapeFactory.createShape(specification));
        } else {
            return Optional.empty();
        }
    }

    private ShapeSpecification createSpecification() {
        try {
            ShapeSpecification specification = new ShapeSpecification();
            specification.setColour(Color.black);
            specification.setLocation(createDefaultLocation());
            specification.setSize(createDefaultSize());
            specification.setRotation(0d);

            return specification;
        } catch (IllegalStateException e) {
            // the whole grid has been generated
            return null;
        }
    }

    private Size createDefaultSize() {
        return new Size(defaultShapeWidth, defaultShapeHeight);
    }

    private Location createDefaultLocation() {
        Location location = new Location(locationCounter.getX() * defaultShapeWidth, locationCounter.getY() * defaultShapeHeight);
        locationCounter.next();
        return location;
    }

}
