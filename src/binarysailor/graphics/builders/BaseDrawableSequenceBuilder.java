package binarysailor.graphics.builders;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.sequences.Sequence;
import binarysailor.graphics.sequences.Sequences;
import binarysailor.graphics.shapes.Location;
import binarysailor.graphics.shapes.Size;

import java.awt.*;
import java.util.*;

public abstract class BaseDrawableSequenceBuilder<S extends Size> {

    private Sequence<Location> locations;
    private Sequence<Color> colours;
    private Sequence<S> sizes;

    public BaseDrawableSequenceBuilder<S> withLocations(Sequence<Location> locations) {
        this.locations = locations;
        return this;
    }

    public BaseDrawableSequenceBuilder<S> withColours(Sequence<Color> colours) {
        this.colours = colours;
        return this;
    }

    public BaseDrawableSequenceBuilder<S> withSizes(Sequence<S> sizes) {
        this.sizes = sizes;
        return this;
    }

    public final Sequence<Drawable> build() {
        java.util.List<Drawable> drawables = new ArrayList<>();

        boolean generate = true;
        while (generate) {
            boolean hasNextColour = colours.hasNext();
            boolean hasNextLocation = locations.hasNext();
            boolean hasNextSize = sizes.hasNext();

            if (hasNextColour && hasNextLocation && hasNextSize) {
                Color colour = colours.getNext();
                Location location = locations.getNext();
                S size = sizes.getNext();
                Drawable drawable = generateDrawable(colour, location, size);
                drawables.add(drawable);
            } else {
                generate = false;
            }
        }

        return Sequences.fromList(drawables);
    }

    protected abstract Drawable generateDrawable(final Color next, final Location location, final S size);

}
