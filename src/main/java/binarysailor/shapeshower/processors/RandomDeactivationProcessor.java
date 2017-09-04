package binarysailor.shapeshower.processors;

import binarysailor.shapeshower.RandomUtils;
import binarysailor.shapeshower.shapes.Shape;

public class RandomDeactivationProcessor extends ShapeProcessorBase {

    private double triggerProbability;

    public RandomDeactivationProcessor(double triggerProbability) {
        this.triggerProbability = triggerProbability;
    }

    @Override
    public Shape process(Shape shape) {
        if (RandomUtils.getBoolean(triggerProbability)) {
            shape.setActive(false);
        }

        return shape;
    }

}
