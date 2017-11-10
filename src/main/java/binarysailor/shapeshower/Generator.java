package binarysailor.shapeshower;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import binarysailor.shapeshower.grid.EqualSizedCellGrid;
import binarysailor.shapeshower.grid.Grid;
import binarysailor.shapeshower.processors.RandomAspectRatioDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomDeactivationProcessor;
import binarysailor.shapeshower.processors.RandomLocationDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomRotationDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomSizeDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomSwitchingColourProcessor;
import binarysailor.shapeshower.production.Layer;
import binarysailor.shapeshower.production.RectangleFactory;
import binarysailor.shapeshower.production.ShapeProductionPipeline;
import binarysailor.shapeshower.samples.TwoSlightlyDifferentGridLayers;
import binarysailor.shapeshower.shapes.Shape;

public class Generator {

    private static final int WIDTH = 4*1920;
    private static final int HEIGHT = 4*1080;

    public static void main(String[] args) throws IOException {
        Image image = new Image(new Dimension(WIDTH, HEIGHT));

        Collection<Layer> layers = TwoSlightlyDifferentGridLayers.generateShapeLayers(WIDTH, HEIGHT);

        for (Layer layer : layers) {
            drawLayer(image, layer);
        }

        save(image);
    }

    private static void save(final Image image) throws IOException {
        try (FileOutput output = new FileOutput()) {
            image.save(output.getOutputStream());
        }
    }

    private static void drawLayer(final Image image, final Layer layer) {
        image.getGraphics().setComposite(layer.getComposite());
        for (Shape shape : layer.getShapes()) {
            if (shape.isActive()) {
                shape.draw(image);
            }
        }
    }


}
