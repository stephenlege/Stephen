package homeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Chap23_1_Java {

    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        insertionSort(list, (e1, e2) -> ((Comparable<E>) e1).compareTo(e2));
    }

    private static <E> void insertionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            E currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && comparator.compare(list[k], currentElement) > 0; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        Integer[] list = {20, -1001, 0, 3, 45, -1, -9, 500, 12, 100};
        insertionSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println();
        String[] list1 = {"nope", "Yes", "maybe", "Balls", "Go", "bouncing", "ahead"};
        insertionSort(list1, (s1, s2) -> s1.compareToIgnoreCase(s2));
        for (int i = 0; i < list1.length; i++) {
            System.out.print(list1[i] + " ");
        }
        System.out.println("");

        MyClass[] list2 = {new MyClass(100), new MyClass(-1), new MyClass(50)};
        insertionSort(list2, new MyClassComparator());

        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i] + " ");
        }
    }
}
