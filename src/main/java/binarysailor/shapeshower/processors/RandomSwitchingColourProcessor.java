package binarysailor.shapeshower.processors;

import binarysailor.shapeshower.Colors;
import binarysailor.shapeshower.shapes.Shape;

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
