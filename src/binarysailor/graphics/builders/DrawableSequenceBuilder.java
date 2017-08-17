package binarysailor.graphics.builders;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.sequences.Sequence;
import binarysailor.graphics.shapes.Location;
import binarysailor.graphics.shapes.Size;

import java.awt.*;

public interface DrawableSequenceBuilder<S extends Size> {
    DrawableSequenceBuilder withLocations(Sequence<Location> locations);

    DrawableSequenceBuilder withColours(Sequence<Color> colours);

    DrawableSequenceBuilder withSizes(Sequence<S> sizes);

    Sequence<Drawable> build();
}
