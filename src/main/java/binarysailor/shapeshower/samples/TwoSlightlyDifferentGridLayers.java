package binarysailor.shapeshower.samples;

import binarysailor.shapeshower.Colors;
import binarysailor.shapeshower.grid.EqualSizedCellGrid;
import binarysailor.shapeshower.grid.Grid;
import binarysailor.shapeshower.processors.*;
import binarysailor.shapeshower.production.Layer;
import binarysailor.shapeshower.production.RectangleFactory;
import binarysailor.shapeshower.production.ShapeProductionPipeline;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

public class TwoSlightlyDifferentGridLayers {
    public static Collection<Layer> generateShapeLayers(int width, int height) {
        ShapeProductionPipeline pipeline1 = createPipeline1(width, height);
        Layer layer1 = new Layer(pipeline1.produceAll(), AlphaComposite.SrcOver);

        ShapeProductionPipeline pipeline2 = createPipeline2(width, height);
        Layer layer2 = new Layer(pipeline2.produceAll(), AlphaComposite.Xor);

        return Arrays.asList(layer1, layer2);
    }

    private static ShapeProductionPipeline createPipeline1(int width, int height) {
        Grid grid1 = new EqualSizedCellGrid(20, 15, width, height, 0, 0);

        ShapeProductionPipeline pipeline = new ShapeProductionPipeline(new RectangleFactory(), grid1);
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
        return pipeline;
    }

    private static ShapeProductionPipeline createPipeline2(final int width, final int height) {
        Grid grid2 = new EqualSizedCellGrid(25, 15, width, height, 200, 50);
        ShapeProductionPipeline pipeline = new ShapeProductionPipeline(new RectangleFactory(), grid2);
        pipeline.addProcessor(new RandomSizeDeviatingProcessor(1.0, -0.45, -0.3));
        pipeline.addProcessor(new RandomLocationDeviatingProcessor(0.3, 12.0, 3.0));
        pipeline.addProcessor(new RandomRotationDeviatingProcessor(0.8, 0.2));
        pipeline.addProcessor(new RandomAspectRatioDeviatingProcessor(1.0, 1.2, 1.4));
        pipeline.addProcessor(new RandomDeactivationProcessor(0.3));
        pipeline.addProcessor(new RandomSwitchingColourProcessor(
                new Colors[] {
                        Colors.withBlackOutline(new Color(23, 210, 10)),
                        Colors.withBlackOutline(new Color(40, 152, 252)),
                        Colors.withBlackOutline(new Color(255, 200, 200))
                },
                new double[] { 0.3, 0.5, 0.2 }));
        return pipeline;
    }
}
