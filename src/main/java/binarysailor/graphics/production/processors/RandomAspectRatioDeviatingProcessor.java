package binarysailor.graphics.production.processors;

import binarysailor.graphics.RandomUtils;
import binarysailor.graphics.shapes.Rectangle;
import binarysailor.graphics.shapes.Shape;

public class RandomAspectRatioDeviatingProcessor extends ShapeProcessorBase {

    private double triggerProbability, minFactor, maxFactor;

    public RandomAspectRatioDeviatingProcessor(double triggerProbability, double minFactor, double maxFactor) {
        this.triggerProbability = triggerProbability;
        this.minFactor = minFactor;
        this.maxFactor = maxFactor;
    }

    @Override
    public Shape process(Shape shape) {
        return shape; // if not a rectangle, do nothing
    }

    @Override
    public Shape process(Rectangle rectangle) {
        if (RandomUtils.getBoolean(triggerProbability)) {
            double factor = RandomUtils.getBetween(minFactor, maxFactor);
            rectangle.setAspectRatio(rectangle.getAspectRatio() * factor);
        }

        return rectangle;
    }
}
