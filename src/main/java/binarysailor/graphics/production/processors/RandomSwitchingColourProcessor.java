package binarysailor.graphics.production.processors;

import binarysailor.graphics.production.ShapeSpecification;
import binarysailor.graphics.production.ShapeSpecificationProcessor;

import java.awt.*;

public class RandomSwitchingColourProcessor implements ShapeSpecificationProcessor {

    private final RandomSwitch<Color> randomSwitch;

    public RandomSwitchingColourProcessor(Color[] colours, double[] probabilities) {
        this.randomSwitch = new RandomSwitch<>(colours, probabilities);
    }

    @Override
    public ShapeSpecification process(final ShapeSpecification specification) {
        specification.setColour(randomSwitch.getNextValue());
        return specification;
    }
}
