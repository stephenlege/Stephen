/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_java;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.geometry.Point2D;

public class Exercise20_04 {

    public static void main(String[] args) {
        Point[] points = new Point[100];
        
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point((Math.random() * 50), 
                    (Math.random() * 50));
        }

        System.out.println("Before sort:");
        List<Point> list = Arrays.asList(points);
        System.out.println(list);
        
        Arrays.sort(points);
        List<Point> list1 = Arrays.asList(points);
        System.out.println("Aescending via X: ");
        System.out.println(list1);
        

        Arrays.sort(points, new CompareY());
        List<Point> list2 = Arrays.asList(points);

        System.out.println("Aescending via Y: ");
        System.out.println(list2);
    }
}
