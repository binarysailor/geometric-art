package binarysailor.graphics.sequences;

import binarysailor.graphics.shapes.Location;

import java.util.Iterator;
import java.util.List;

public class Sequences {

    public static <T> Sequence<T> fromList(List<T> list) {
        final Iterator<T> iterator = list.iterator();
        return new Sequence<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T getNext() {
                return iterator.next();
            }
        };
    }

    public static <T> Sequence<T> constant(final T value) {
        return new Sequence<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T getNext() {
                return value;
            }
        };
    }

    @SafeVarargs
    public static <T> RandomSwitchingSequenceBuilder<T> randomlySwitching(final T... values) {
        return new RandomSwitchingSequenceBuilder<T>(values);
    }

    public static Sequence<Location> composeLocations(final Sequence<Integer> x, final Sequence<Integer> y) {
        return new Sequence<Location>() {
            @Override
            public boolean hasNext() {
                return x.hasNext() && y.hasNext();
            }

            @Override
            public Location getNext() {
                return new Location(x.getNext(), y.getNext());
            }
        };
    }

    public static Sequence<Location> gridLocations(final int colOffset, final int rowOffset, final int cols, final int rows, final int spacing) {
        return new Sequence<Location>() {

            private int col = 0, row = 0;

            @Override
            public boolean hasNext() {
                return row < rows;
            }

            @Override
            public Location getNext() {
                if (hasNext()) {
                    Location result = new Location(col * spacing + colOffset, row * spacing + rowOffset);
                    col++;
                    if (col == cols) {
                        col = 0;
                        row++;
                    }
                    return result;
                } else {
                    throw new IllegalStateException("All locations in the grid have been generated");
                }
            }
        };
    }
}
