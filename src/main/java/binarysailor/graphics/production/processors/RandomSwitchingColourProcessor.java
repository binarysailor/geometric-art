package binarysailor.graphics.production.processors;

import binarysailor.graphics.production.Colors;
import binarysailor.graphics.shapes.Shape;

public class RandomSwitchingColourProcessor extends ShapeProcessorBase {

    private final RandomSwitch<Colors> randomSwitch;

    public RandomSwitchingColourProcessor(Colors[] colors, double[] probabilities) {
        this.randomSwitch = new RandomSwitch<>(colors, probabilities);
    }

    @Override
    public Shape process(Shape shape) {
        Colors colors = randomSwitch.getNextValue();

        Colors target = shape.getColors();
        target.setOutlineColor(colors.getOutlineColor());
        target.setPaintColor(colors.getPaintColor());

        return shape;
    }
}
