/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16_java;

import java.util.Comparator;

/**
 *
 * @author Greg
 */
abstract class GeometricObject {
    double area;
    public abstract double getArea();
    public void setArea(double area){this.area = area;}
}
class GeometricObjectComparator implements Comparator<GeometricObject>{

    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        if (o1.getArea() > o2.getArea())
            return 1;
        else if(o1.getArea() < o2.getArea())
            return -1;
        else
            return 0;
    }
}
    
    class Circle extends GeometricObject{
        double radius;

        public double getRadius() {
            return radius;
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
        
        

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public String toString() {
            return "Circle{" + "radius=" + radius + '}';
        }
    }
    
    class Rectangle extends GeometricObject{
        double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

        
        
    @Override
    public double getArea() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "length=" + length + ", width=" + width + '}';
    }
        
        
    }
    

