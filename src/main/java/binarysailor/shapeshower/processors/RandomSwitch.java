package binarysailor.shapeshower.processors;

import binarysailor.shapeshower.RandomUtils;

/**
 * Given a set of N values and N probabilities, returns random one of the values each time,
 * where the probability of returning values[i] is probabilities[i]
 */
class RandomSwitch<T> {
    private T[] values;
    private double[] probabilities;

    public RandomSwitch(final T[] values, final double[] probabilities) {
        this.values = values;
        this.probabilities = probabilities;
    }

    T getNextValue() {
        double rnd = RandomUtils.getDouble();
        double accum = 0.0;
        int i = 0;
        while (i < values.length) {
            accum += (probabilities != null ? probabilities[i] : 1.0 / values.length);
            if (accum > rnd) {
                break;
            } else {
                i++;
            }
        }
        return values[Math.min(i, values.length)];
    }
}
