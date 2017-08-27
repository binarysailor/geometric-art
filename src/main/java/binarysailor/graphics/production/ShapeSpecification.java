package binarysailor.graphics.production;

import binarysailor.graphics.shapes.Location;

import java.awt.*;

public class ShapeSpecification {
    private Size size;
    private Location location;
    private double rotation;
    private Color colour;

    public Size getSize() {
        return size;
    }

    public void setSize(final Size size) {
        this.size = size;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(final double rotation) {
        this.rotation = rotation;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(final Color colour) {
        this.colour = colour;
    }
}
