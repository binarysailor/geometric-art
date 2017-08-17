package binarysailor.graphics;


import binarysailor.graphics.builders.CircleSequenceBuilder;
import binarysailor.graphics.builders.DrawableSequenceBuilders;
import binarysailor.graphics.sequences.Sequence;
import binarysailor.graphics.sequences.Sequences;
import binarysailor.graphics.shapes.CircleSize;

import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static binarysailor.graphics.sequences.SequenceDecorators.randomDeviations;
import static binarysailor.graphics.sequences.Sequences.constant;
import static binarysailor.graphics.sequences.Sequences.gridLocations;
import static binarysailor.graphics.sequences.Sequences.randomlySwitching;

public class Generator {
    public static void main(String[] args) throws IOException {
        int w = 1920;
        int h = 1080;
        Image image = new Image(new Dimension(w, h));

        Sequence<Drawable> drawables = generateSequence();

        while (drawables.hasNext()) {
            drawables.getNext().draw(image);
        }

        DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = String.format("image-%s.png", df.format(new Date()));
        image.save("D:/" + fileName);
    }

    private static Sequence<Drawable> generateSequence() {
        CircleSequenceBuilder builder = DrawableSequenceBuilders.circles();
        builder
                .withColours(randomlySwitching(new Color(255, 160, 160), new Color(255, 200, 200), new Color(255, 180, 180)).uniform())
                .withSizes(randomDeviations(constant(new CircleSize(70)), 15, 18))
                .withLocations(gridLocations(10, 10, 7, 4, 160));
        return builder.build();
    }
}
