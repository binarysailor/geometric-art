package binarysailor.graphics.production;

import java.awt.Color;

public class Colors {

    private Color paintColor, outlineColor;

    public static Colors same(Color color) {
        return new Colors(color, color);
    }

    public static Colors withBlackOutline(Color color) {
        return new Colors(color, Color.BLACK);
    }

    public Colors(Color paintColor, Color outlineColor) {
        this.paintColor = paintColor;
        this.outlineColor = outlineColor;
    }

    public Color getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(Color paint) {
        this.paintColor = paint;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(Color outline) {
        this.outlineColor = outline;
    }

}
