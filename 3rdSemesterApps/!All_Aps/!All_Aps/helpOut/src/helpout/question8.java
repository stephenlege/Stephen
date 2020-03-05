/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpout;

/**
 *
 * @author Greg
 */
public class question8 {
    public static void xfunction(int n) {
    if (n > 0) {
       System.out.print(n % 10 + " ");
    xfunction(n / 10);
    }
}
    public static void main(String[] args) {
        xfunction(1234);
    }
}
