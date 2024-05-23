package classesInterfaces.geometricCalculation;

public class RectangularRoomCalculator implements GeometricCalculation {
    @Override
    public double calculateArea(double height, double width) {
        return height * width;
    }

    @Override
    public double calculatePerimeter(double height, double width) {
        return 2 * (height + width);
    }
}
