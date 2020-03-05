/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap19_java;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Greg
 */
public class GenericsRule12 {
    public static <T> //generic type declared
        List<? extends T> //return type
                f12(List<? extends T> list){
                    return list;
                }
        public static <T> //generic type declared
        List<? super T> //return type
                f13(List<? extends T> list){
                    ArrayList<Object> l = new ArrayList();
                    l.add(10);
                    l.add("abc");
                    l.addAll(2, list);
                    return l;
                }
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        
        l1.add(10);
        System.out.println(f12(l1));
        System.out.println(f13(l1));
    }
}

