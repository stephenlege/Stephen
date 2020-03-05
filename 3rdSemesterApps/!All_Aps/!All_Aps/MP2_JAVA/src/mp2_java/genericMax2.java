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
public class genericMax2 {

    public static void main(String[] args) {
        Integer[][] numbers = {{11, 22, 8}, {0, 4, 50}};
        System.out.println(max(numbers));
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];

        for (int i = 1; i < list.length; i++) {
            for (int j = 1; j < list[i].length; j++) {
                if (max.compareTo(list[i][j]) < 0) {
                    max = list[i][j];
                }
            }
        }

        return max;
    }
}
