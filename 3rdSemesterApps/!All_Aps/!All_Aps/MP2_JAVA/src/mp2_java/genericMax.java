/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2_java;

/**
 *
 * @author Greg
 */
public class genericMax {

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];

        for (int i = 0; i < list.length; i++) {
            if (max.compareTo(list[i]) < 0) {
                max = list[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3};
        System.out.println(max(numbers));
    }
}
