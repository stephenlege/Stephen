/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_generic_dao;

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
