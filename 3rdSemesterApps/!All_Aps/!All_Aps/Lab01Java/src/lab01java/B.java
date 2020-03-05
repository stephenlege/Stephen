/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01java;

/**
 *
 * @author Greg
 */
public class B implements java.io.Serializable{
    int v1;
    static double v2 = 10.12;
    transient A v3;
    A v4;

    public B() {
        v1 = 100;
        v3 = new A();
        v4 = new A();
    }

    public B(int v1, A v3, A v4) {
        this.v1 = v1;
        this.v3 = v3;
        this.v4 = v4;
    }

    @Override
    public String toString() {
        return "B{" + "v1=" + v1 + ", v4=" + v4 + '}';
    }

    
    
    
    
    
}
