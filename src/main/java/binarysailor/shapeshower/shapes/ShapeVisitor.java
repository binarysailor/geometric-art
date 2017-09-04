package binarysailor.shapeshower.shapes;


public interface ShapeVisitor {
    Shape visit(Shape shape);
    Shape visit(Rectangle rectangle);
    Shape visit(Circle circle);
}
