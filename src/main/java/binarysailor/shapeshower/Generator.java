package binarysailor.shapeshower;


import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import binarysailor.shapeshower.grid.EqualSizedCellGrid;
import binarysailor.shapeshower.grid.Grid;
import binarysailor.shapeshower.processors.RandomAspectRatioDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomDeactivationProcessor;
import binarysailor.shapeshower.processors.RandomLocationDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomRotationDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomSizeDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomSwitchingColourProcessor;
import binarysailor.shapeshower.production.RectangleFactory;
import binarysailor.shapeshower.production.ShapeProductionPipeline;
import binarysailor.shapeshower.shapes.Shape;

public class Generator {

    private static final int WIDTH = 4*1920;
    private static final int HEIGHT = 4*1080;

    public static void main(String[] args) throws IOException {
        Image image = new Image(new Dimension(WIDTH, HEIGHT));

        Iterable<Shape> shapes = generateShapes();

        for (Shape shape : shapes) {
            if (shape.isActive()) {
                shape.draw(image);
            }
        }

        image.save(generateFilePath());
    }

    private static Iterable<Shape> generateShapes() {
        Grid grid = new EqualSizedCellGrid(20, 15, WIDTH, HEIGHT, 0, 0);

        ShapeProductionPipeline pipeline = new ShapeProductionPipeline(new RectangleFactory(), grid);
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

        return pipeline.produceAll();
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