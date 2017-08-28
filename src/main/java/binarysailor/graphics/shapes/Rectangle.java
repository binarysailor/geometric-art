package binarysailor.graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import binarysailor.graphics.Drawable;
import binarysailor.graphics.Image;

public class Rectangle implements Drawable {

    private Color colour;
    private Location topLeft;
    private int width, height;
    private double angle;

    public Rectangle(Location topLeft, int width, int height, double angle, Color colour) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
        this.angle = angle;
        this.colour = colour;
    }

    @Override
    public void draw(Image target) {
        Graphics2D graphics = target.getGraphics();
        AffineTransform transform = graphics.getTransform();
        graphics.rotate(angle, topLeft.x() + width/2, topLeft.y() + height/2 );
        graphics.setPaint(colour);
        graphics.fillRect(topLeft.x(), topLeft.y(), width, height);
        graphics.setStroke(new BasicStroke(0.5f));
        graphics.setColor(Color.black); // stroke
        graphics.drawRect(topLeft.x(), topLeft.y(), width, height);
        graphics.setTransform(transform);
    }

}
