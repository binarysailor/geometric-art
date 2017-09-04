package binarysailor.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

    private final Dimension size;
    private final BufferedImage bufferedImage;
    private final Graphics2D graphics;

    public Image(final Dimension size) {
        this.size = size;
        this.bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        this.graphics = (Graphics2D) bufferedImage.getGraphics();
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
