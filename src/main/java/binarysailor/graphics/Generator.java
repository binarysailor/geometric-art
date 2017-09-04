package binarysailor.graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Optional;

import binarysailor.graphics.production.CircleFactory;
import binarysailor.graphics.production.Colors;
import binarysailor.graphics.production.Grid;
import binarysailor.graphics.production.ShapeProductionPipeline;
import binarysailor.graphics.production.processors.RandomAspectRatioDeviatingProcessor;
import binarysailor.graphics.production.processors.RandomDeactivationProcessor;
import binarysailor.graphics.production.processors.RandomLocationDeviatingProcessor;
import binarysailor.graphics.production.processors.RandomRotationDeviatingProcessor;
import binarysailor.graphics.production.processors.RandomSizeDeviatingProcessor;
import binarysailor.graphics.production.processors.RandomSwitchingColourProcessor;
import binarysailor.graphics.shapes.Shape;

public class Generator {

    private static final int WIDTH = 4*1920;
    private static final int HEIGHT = 4*1080;

    public static void main(String[] args) throws IOException {
        Image image = new Image(new Dimension(WIDTH, HEIGHT));

        Iterable<Shape> drawables = generateSequence();


        for (Shape drawable : drawables) {
            if (drawable.isActive()) {
                drawable.draw(image);
            }
        }

        image.save(generateFilePath());
    }

    private static Iterable<Shape> generateSequence() {
        Grid grid = new Grid(12, 9, WIDTH, HEIGHT);
        ShapeProductionPipeline pipeline = new ShapeProductionPipeline(new CircleFactory(), grid);

        pipeline.addProcessor(new RandomSizeDeviatingProcessor(1.0, -0.45, -0.3));
        pipeline.addProcessor(new RandomLocationDeviatingProcessor(0.3, 12.0, 3.0));
        pipeline.addProcessor(new RandomRotationDeviatingProcessor(0.8, 0.2));
        pipeline.addProcessor(new RandomAspectRatioDeviatingProcessor(1.0, 1.2, 1.4));
        pipeline.addProcessor(new RandomDeactivationProcessor(0.3));
        pipeline.addProcessor(new RandomSwitchingColourProcessor(
                new Colors[] { 
                        Colors.withBlackOutline(new Color(241, 10, 10)), 
                        Colors.withBlackOutline(new Color(253, 152, 152)), 
                        Colors.withBlackOutline(new Color(255, 200, 200))
                        },
                new double[] { 0.3, 0.5, 0.2 }));

        Collection<Shape> drawables = new LinkedList<>();
        Optional<Shape> drawableOptional;
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
