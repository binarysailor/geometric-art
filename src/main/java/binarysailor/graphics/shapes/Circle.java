package binarysailor.graphics.shapes;

import binarysailor.graphics.*;
import binarysailor.graphics.Image;

import java.awt.*;

public class Circle implements Drawable {
    private Color colour;
    private int r;
    private Location center;

    public Circle(final Color colour, final int r, final Location center) {
        this.colour = colour;
        this.r = r;
        this.center = center;
    }

    @Override
    public void draw(final Image target) {
        Graphics2D graphics = target.getGraphics();
        graphics.setColor(colour);
        graphics.fillOval(center.x() - r, center.y() - r, 2*r, 2*r);
    }
}
