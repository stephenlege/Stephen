package lab04_java;

public class Point implements Comparable<Point> {

    private double x;
    private double y;

    Point() {
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int compareTo(Point point) {
        if (x == point.getX()) {

            if (y > point.getY()) {
                return 1;
            } else if (y < point.getY()) {
                return -1;
            } else {
                return 0;
            }
        } else if (x > point.getX()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
    }
}
