package binarysailor.graphics.sequences;

import binarysailor.graphics.RandomNumbers;

import java.util.Random;

class RandomSwitchingSequence<T> implements Sequence<T> {

    private T[] values;
    private double[] thresholds;
    private Random random = new Random();

    RandomSwitchingSequence(T[] values) {
        this.values = values;
    }

    RandomSwitchingSequence(T[] values, double[] thresholds) {
        this(values);
        this.thresholds = thresholds;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T getNext() {
        double rnd = RandomNumbers.getDouble();
        double accum = 0.0;
        int i = 0;
        while (i < values.length) {
            accum += (thresholds != null ? thresholds[i] : 1.0 / values.length);
            if (accum > rnd) {
                break;
            } else {
                i++;
            }
        }
        return values[Math.min(i, values.length)];
    }
}
