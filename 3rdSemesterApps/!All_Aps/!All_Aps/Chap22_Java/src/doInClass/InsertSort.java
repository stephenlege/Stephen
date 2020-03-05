/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doInClass;

/**
 *
 * @author Greg
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] list = {-5, 5, 10, -12, 50};

        insertSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("");
        

    }

    public static void insertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int element = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > element; k--) {
                list[k + 1] = list[k];
            }

            list[k + 1] = element;

        }
    }
}
