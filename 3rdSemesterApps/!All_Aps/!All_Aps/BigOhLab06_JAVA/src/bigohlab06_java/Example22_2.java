
package bigohlab06_java;

import java.util.LinkedList;
import java.util.Scanner;

public class Example22_2 {
    
    
    private static void sub2(LinkedList<Character> max, String string){
           for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = input.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        
        sub2(max, string);

     for (Character ch : max) {
            System.out.print(ch);
        }
        System.out.println();
    
}
}