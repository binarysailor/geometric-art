package binarysailor.graphics.builders;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.shapes.Circle;
import binarysailor.graphics.shapes.CircleSize;
import binarysailor.graphics.shapes.Location;

import java.awt.*;

public class CircleSequenceBuilder extends BaseDrawableSequenceBuilder<CircleSize> {

    @Override
    protected Drawable generateDrawable(final Color colour, final Location location, final CircleSize size) {
        return new Circle(colour, size.getR(), location);
    }
}
