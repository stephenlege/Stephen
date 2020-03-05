/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.singleton_dao_generic;

/**
 *
 * @author ASDV2
 */
public interface Categorable<T extends CharSequence>
{
    //
    public T getCategory();
    public void setCategory( T t );
    
}
