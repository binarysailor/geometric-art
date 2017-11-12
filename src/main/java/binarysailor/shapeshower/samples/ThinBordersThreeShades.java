package binarysailor.shapeshower.samples;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;

import binarysailor.shapeshower.Colors;
import binarysailor.shapeshower.grid.EqualSizedCellGrid;
import binarysailor.shapeshower.grid.Grid;
import binarysailor.shapeshower.processors.RandomAspectRatioDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomLocationDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomRotationDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomSizeDeviatingProcessor;
import binarysailor.shapeshower.processors.RandomSwitchingColourProcessor;
import binarysailor.shapeshower.production.Layer;
import binarysailor.shapeshower.production.RectangleFactory;
import binarysailor.shapeshower.production.ShapeProductionPipeline;

public class ThinBordersThreeShades {
    public static Collection<Layer> generateShapeLayers(int width, int height) {
        Grid grid1 = new EqualSizedCellGrid(20, 15, width, height, 0, 0);

        ShapeProductionPipeline pipeline = new ShapeProductionPipeline(new RectangleFactory(), grid1);
        pipeline.addProcessor(new RandomSizeDeviatingProcessor(0.5, -0.15, -0.05));
        pipeline.addProcessor(new RandomLocationDeviatingProcessor(0.3, 12.0, 3.0));
        pipeline.addProcessor(new RandomRotationDeviatingProcessor(0.8, 0.2));
        pipeline.addProcessor(new RandomAspectRatioDeviatingProcessor(1.0, 1.2, 1.4));
        //pipeline.addProcessor(new RandomDeactivationProcessor(0.3));
        pipeline.addProcessor(new RandomSwitchingColourProcessor(
                new Colors[] { 
                        Colors.withBlackOutline(new Color(241, 10, 10)), 
                        Colors.withBlackOutline(new Color(253, 152, 152)), 
                        Colors.withBlackOutline(new Color(255, 200, 200))
                        },
                new double[] { 0.3, 0.5, 0.2 }));
        Layer layer1 = new Layer(pipeline.produceAll(), AlphaComposite.SrcOver);

        return Arrays.asList(layer1);
    }
}
