package binarysailor.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private final Dimension size;
    private final BufferedImage bufferedImage;
    private final Graphics2D graphics;

    public Image(final Dimension size) {
        this.size = size;
        this.bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        this.graphics = (Graphics2D) bufferedImage.getGraphics();

        double factor = Math.max(size.getWidth(), size.getHeight()) / 1000;
        this.graphics.transform(new AffineTransform(factor, 0, 0, factor, 0, 0));
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public Dimension getSize() {
        return size;
    }

    public void save(String path) throws IOException {
        File file = new File(path);
        ImageIO.write(bufferedImage, "png", file);
    }
}
