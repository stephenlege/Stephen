/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestQuestionsCheck;

import java.util.ArrayList;
import java.util.List;

//Question 2
public class X {

    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Integer>();
        ArrayList<? extends String> list3 = new ArrayList<String>();

        //list3.add("abc");

        //list1.add(5);
        //A1<Integer> a1 = new B1<Number>();
        //A1<Number> a2 = new B1<Integer>();
        A1<Number> a3 = new B1<Number>();
        list3.size();

     
     
     
    }
}

class A1<T> {
}

class B1<T> extends A1<T> {
}

class C1<T> extends B1<T> {
}
