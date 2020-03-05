/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01java;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class C implements Serializable{
    
    ArrayList<B> arrayList;
    public C(){
        arrayList = new ArrayList<B>();
        arrayList.add(new B(7, new A("Monday"), new A ("January")));
        arrayList.add(new B(8, new A("Sunday"), new A("August")));
    }

    @Override
    public String toString() {
        return "C{" + "arrayList=" + arrayList + '}';
    }
    
    public static void main(String[] args) {
        System.out.println(new B());
        System.out.println(new A("stringy"));
        System.out.println(new C().toString());
    }
    
}
