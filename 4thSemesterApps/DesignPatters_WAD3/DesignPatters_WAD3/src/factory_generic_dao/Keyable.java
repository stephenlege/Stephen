/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_generic_dao;

public interface Keyable<K>
{
    public K getKey();
    public void setKey( K key);
}
