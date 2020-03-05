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
public class MailBox implements Box, Mailer{
    private Box box;
    
    public MailBox(Box box){
        this.box = box;
    }

     @Override
    public void pack() {                        //from
        box.pack();
    }

    @Override
    public void seal() {                        //from
        box.seal();
    }
    
    public void addPostage(){
        System.out.println("affix stampage");
    }
    public void ship(){
        System.out.println("put in mailbox");
    }
    
    public void load(Box b){
        b.pack();
    }
    
}
