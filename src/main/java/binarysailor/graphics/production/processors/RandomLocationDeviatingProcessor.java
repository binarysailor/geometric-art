package binarysailor.graphics.production.processors;

import binarysailor.graphics.RandomNumbers;
import binarysailor.graphics.production.ShapeSpecification;
import binarysailor.graphics.production.ShapeSpecificationProcessor;

public class RandomLocationDeviatingProcessor implements ShapeSpecificationProcessor {
    private final double probability;
    private final int maxShift;

    public RandomLocationDeviatingProcessor(double probability, int maxShift) {
        this.probability = probability;
        this.maxShift = maxShift;
    }

    @Override
    public ShapeSpecification process(final ShapeSpecification specification) {
        if (RandomNumbers.getDouble() < probability) {
            // deviate
            int shiftX = (int)(maxShift * (RandomNumbers.getDouble() - 0.5));
            int shiftY = (int)(maxShift * (RandomNumbers.getDouble() - 0.5));

            specification.setLocation(specification.getLocation().translate(shiftX, shiftY));
        }

        return specification;
    }
}
