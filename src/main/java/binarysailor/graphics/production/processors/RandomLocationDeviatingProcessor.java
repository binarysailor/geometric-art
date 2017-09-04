package binarysailor.graphics.production.processors;

import binarysailor.graphics.RandomUtils;
import binarysailor.graphics.shapes.Shape;

public class RandomLocationDeviatingProcessor extends ShapeProcessorBase {
    private final double probability;
    private final double maxShiftX, maxShiftY;

    public RandomLocationDeviatingProcessor(double probability, double maxShiftX, double maxShiftY) {
        this.probability = probability;
        this.maxShiftX = maxShiftX;
        this.maxShiftY = maxShiftY;
    }

    @Override
    public Shape process(Shape shape) {
        if (RandomUtils.getBoolean(probability)) {
            // deviate
            double shiftX = RandomUtils.getBetweenMinusAndPlus(maxShiftX);
            shape.setXOffsetFactor(shiftX);
            double shiftY = RandomUtils.getBetweenMinusAndPlus(maxShiftY);
            shape.setYOffsetFactor(shiftY);
        }

        return shape;
    }
}
