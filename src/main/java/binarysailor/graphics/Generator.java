package binarysailor.graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import binarysailor.graphics.production.CircleFactory;
import binarysailor.graphics.production.ShapeProductionPipeline;
import binarysailor.graphics.production.processors.RandomLocationDeviatingProcessor;
import binarysailor.graphics.production.processors.RandomSizeDeviatingProcessor;
import binarysailor.graphics.production.processors.RandomSwitchingColourProcessor;

public class Generator {

    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;

    public static void main(String[] args) throws IOException {
        Image image = new Image(new Dimension(WIDTH, HEIGHT));

        Iterable<Drawable> drawables = generateSequence();

        for (Drawable drawable : drawables) {
            drawable.draw(image);
        }

        image.save(generateFilePath());
    }

    private static Iterable<Drawable> generateSequence() {
        ShapeProductionPipeline pipeline = new ShapeProductionPipeline(new CircleFactory(), 10, 6, ((double)WIDTH)/1080);

        pipeline.addProcessor(new RandomSizeDeviatingProcessor(0.4, 0.1));
        pipeline.addProcessor(new RandomLocationDeviatingProcessor(0.3, 30));
        pipeline.addProcessor(new RandomSwitchingColourProcessor(
                new Color[] { new Color(255, 100, 100), new Color(255, 200, 200), new Color(255, 150, 150) },
                new double[] { 0.4, 0.4, 0.2 }));

        Collection<Drawable> drawables = new LinkedList<>();
        Optional<Drawable> drawableOptional;
        do {
            drawableOptional = pipeline.produce();
            if (drawableOptional.isPresent()) {
                drawables.add(drawableOptional.get());
            }
        } while (drawableOptional.isPresent());

        return drawables;
    }

    private static String generateFilePath() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = String.format("geometric-art-%s.png", df.format(new Date()));
        String directory = System.getProperty("user.home");
        if (directory == null) {
            directory = ".";
        }

        File subdirectory = new File(directory + File.separatorChar + "geometric-art");
        if (!subdirectory.exists()) {
            subdirectory.mkdirs();
        }
        return subdirectory.getPath() + File.separatorChar + fileName;
    }
}
