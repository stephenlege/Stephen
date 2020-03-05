/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Greg
 */
@Named(value = "states")
@RequestScoped
public class States {

    private String outcome = null;

    private Rectangle texas = new Rectangle(170, 160, 550, 550);
    private Rectangle louisiana = new Rectangle(700,300,210,260);
    private Rectangle arkansas = new Rectangle(700,90,210,210);
    private Rectangle mississippi = new Rectangle(905,0,150,430);

    public States() {

    }

    public void handleMouseClick(ActionEvent e) {

        FacesContext context = FacesContext.getCurrentInstance();
        String clientId = e.getComponent().getClientId(context);
        Map<String, String> requestParams
                = context.getExternalContext().getRequestParameterMap();

        int x = new Integer((String) requestParams.get(clientId + ".x")).intValue();
        int y = new Integer((String) requestParams.get(clientId + ".y")).intValue();

        outcome = null;

        if (texas.contains(new Point(x, y))) {
            outcome = "texas";
        }

        if (louisiana.contains(new Point(x, y))) {
            outcome = "louisiana";
        }

        if (arkansas.contains(new Point(x, y))) {
            outcome = "arkansas";
        }

        if (mississippi.contains(new Point(x, y))) {
            outcome = "mississippi";
        }

    }

    public String navigate() {
        return outcome;
    }

}
