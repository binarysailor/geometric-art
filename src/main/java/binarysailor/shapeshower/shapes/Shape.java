package binarysailor.shapeshower.shapes;

import binarysailor.shapeshower.Colors;
import binarysailor.shapeshower.Image;
import binarysailor.shapeshower.grid.GridCell;

public interface Shape {
    boolean isActive();
    void setActive(boolean active);
    GridCell getCell();
    void draw(Image target);
    Colors getColors();
    double getRotation();
    void setRotation(double rotation);
    double getXOffsetFactor();
    void setXOffsetFactor(double shiftX);
    double getYOffsetFactor();
    void setYOffsetFactor(double shiftY);
    double getSizeFactor();
    void setSizeFactor(double sizeFactor);
    Shape accept(ShapeVisitor visitor);
}
