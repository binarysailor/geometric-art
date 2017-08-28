package binarysailor.graphics.production.processors;

import binarysailor.graphics.RandomNumbers;
import binarysailor.graphics.production.ShapeSpecification;
import binarysailor.graphics.production.ShapeSpecificationProcessor;

public class RandomRotationDeviatingProcessor implements ShapeSpecificationProcessor {

    private final double probability;
    private final double maxRotation;

    public RandomRotationDeviatingProcessor(double probability, double maxRotation) {
        this.probability = probability;
        this.maxRotation = maxRotation;
    }

    @Override
    public ShapeSpecification process(final ShapeSpecification specification) {
        if (RandomNumbers.getDouble() < probability) {
            // deviate
            double rotation = maxRotation * (RandomNumbers.getDouble() - 0.5);
            specification.setRotation(rotation);
        }

        return specification;
    }

}
