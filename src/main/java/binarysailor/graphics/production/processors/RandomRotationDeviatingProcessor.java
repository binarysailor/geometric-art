package binarysailor.graphics.production.processors;

import binarysailor.graphics.RandomUtils;
import binarysailor.graphics.shapes.Shape;

public class RandomRotationDeviatingProcessor extends ShapeProcessorBase {

    private final double probability;
    private final double maxRotation;

    public RandomRotationDeviatingProcessor(double probability, double maxRotation) {
        this.probability = probability;
        this.maxRotation = maxRotation;
    }

    @Override
    public Shape process(final Shape shape) {
        if (RandomUtils.getBoolean(probability)) {
            // deviate
            shape.setRotation(RandomUtils.getBetweenMinusAndPlus(maxRotation));
        }

        return shape;
    }

}
