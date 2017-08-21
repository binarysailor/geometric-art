package binarysailor.graphics.sequences;

import binarysailor.graphics.RandomNumbers;
import binarysailor.graphics.shapes.Size;

public class SequenceDecorators {
    public static <S extends Size> Sequence<S> randomDeviations(final Sequence<S> sizes, final double probability, final double maxFactor) {
        return new Sequence<S>() {
            @Override
            public boolean hasNext() {
                return sizes.hasNext();
            }

            @Override
            public S getNext() {
                S size = sizes.getNext();
                if (RandomNumbers.getDouble() < probability) {
                    // deviate
                    double deviation = maxFactor * RandomNumbers.getDouble();
                    @SuppressWarnings("unchecked")
                    S result = (S)size.scale(1.0 + deviation/100);

                    return result;
                } else {
                    return size;
                }
            }
        };

    }
}
