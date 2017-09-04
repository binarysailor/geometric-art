package binarysailor.graphics.shapes;

import binarysailor.graphics.Image;
import binarysailor.graphics.production.Colors;
import binarysailor.graphics.production.GridCell;
import binarysailor.graphics.production.ShapeProcessor;

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
    Shape accept(ShapeProcessor processor);
}
