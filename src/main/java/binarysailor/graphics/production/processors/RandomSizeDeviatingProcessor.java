package binarysailor.graphics.production.processors;

import binarysailor.graphics.RandomNumbers;
import binarysailor.graphics.production.ShapeSpecification;
import binarysailor.graphics.production.ShapeSpecificationProcessor;
import binarysailor.graphics.production.Size;

public class RandomSizeDeviatingProcessor implements ShapeSpecificationProcessor {

    private final double probability, maxFactor;

    public RandomSizeDeviatingProcessor(double probability, double maxFactor) {
        this.probability = probability;
        this.maxFactor = maxFactor;
    }

    @Override
    public ShapeSpecification process(final ShapeSpecification specification) {
        if (RandomNumbers.getDouble() < probability) {
            // deviate
            double factor = 1.0 + maxFactor * RandomNumbers.getDouble();

            Size size = specification.getSize();
            size.setWidth((int)(size.getWidth() * factor));
            size.setHeight((int)(size.getHeight() * factor));
        }

        return specification;
    }
}
