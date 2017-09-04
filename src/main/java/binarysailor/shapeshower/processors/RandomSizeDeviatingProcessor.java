package binarysailor.shapeshower.processors;

import binarysailor.shapeshower.RandomUtils;
import binarysailor.shapeshower.shapes.Shape;

public class RandomSizeDeviatingProcessor extends ShapeProcessorBase {

    private final double probability, deviationLowerBound, deviationUpperBound;

    public RandomSizeDeviatingProcessor(double triggerProbability, double lowerBound, double upperBound) {
        this.probability = triggerProbability;
        this.deviationUpperBound =  lowerBound;
        this.deviationLowerBound =  upperBound;
    }

    public RandomSizeDeviatingProcessor(double triggerProbability, double maxDeviation) {
        this(triggerProbability, -Math.abs(maxDeviation), Math.abs(maxDeviation));
    }

    @Override
    public Shape process(final Shape shape) {
        if (RandomUtils.getBoolean(probability)) {
            // deviate
            double factor = 1.0 + RandomUtils.getBetween(deviationLowerBound, deviationUpperBound);
            factor = Math.max(factor, 0.0);
            shape.setSizeFactor(factor);
        }

        return shape;
    }
}
