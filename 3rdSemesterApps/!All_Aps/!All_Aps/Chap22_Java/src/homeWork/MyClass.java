/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeWork;

/**
 *
 * @author Greg
 */
public class MyClass<E extends Comparable<E>>{
    public int instant;

    public MyClass(int instant) {
        this.instant = instant;
    }

    public int getInstant() {
        return instant;
    }

    public void setInstant(int instant) {
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "MyClass{" + "instant=" + instant + '}';
    }

//    @Override
//    public int compareTo(E o) {
//        return this.compareTo(o);
//    }

    void compareTo(MyClass s2) {
        this.compareTo(s2);
    }

  
    
    
}
