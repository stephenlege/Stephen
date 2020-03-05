/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.singleton_dao_generic;

import java.util.Collection;

/**
 *
 * @author ASDV2
 */
public interface Product<T extends Keyable>
{

    public void create(T t);

    public void delete(T t);

    public void update(T t);

    public T find(T t);

    public Collection<T> findAll();

}
