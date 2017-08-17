package binarysailor.graphics.sequences;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class RandomSwitchingSequenceBuilder<T> {
    private final T[] values;

    public RandomSwitchingSequenceBuilder(final T[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("At least one value is needed to choose from");
        }
        this.values = values;
    }

    public Sequence<T> uniform() {
        return new RandomSwitchingSequence<T>(values);
    }

    public Sequence<T> withProbabilities(String... probabilities) {
        double[] p = convertProbabilities(probabilities);
        return new RandomSwitchingSequence<T>(values, p);
    }

    private double[] convertProbabilities(final String[] probabilities) {
        double[] result = new double[probabilities.length];
        for (int i = 0; i < probabilities.length; i++) {
            result[i] = Double.parseDouble(probabilities[i]);
        }
        validateProbabilities(result);

        return result;
    }

    private void validateProbabilities(final double[] probabilities) {
        if (probabilities.length != values.length - 1) {
            throw new IllegalArgumentException(
                    String.format("%d values require %d probabilities", values.length, values.length - 1));
        }
        if (DoubleStream.of(probabilities).sum() > 1.0) {
            throw new IllegalArgumentException("The sum of probabilities cannot be larger than 1.0");
        }
    }
}
