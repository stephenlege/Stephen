/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cohesion1;

/**
 *
 * @author LEGE
 */
public class GiftBox implements Box{

    @Override
    public void pack() {                        //from
        System.out.println("Pack the Box");    //interface
    }

    @Override
    public void seal() {                        //from
        System.out.println("Seal Box");         //interface
    }
    
}
