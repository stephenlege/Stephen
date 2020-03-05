/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import bl.singleton_dao_generic.WarehouseSingleton;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

/**
 *
 * @author LEGE
 */
@Named(value = "initializationBean")
@ApplicationScoped
public class InitializationBean {

    private static WarehouseSingleton ws;

    public InitializationBean() {

    }

    public void init(
            @Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println("initialiaze singlenton");
        ws = WarehouseSingleton.instantiateWarehouse();
    }

    public static WarehouseSingleton getWs() {
        return ws;
    }

    public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
        //cleanup and save
    }

}
