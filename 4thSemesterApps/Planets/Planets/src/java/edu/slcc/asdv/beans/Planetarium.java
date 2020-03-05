package edu.slcc.asdv.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named 
@RequestScoped
public class Planetarium implements Serializable {

    private String selectedPlanet;

    public String getSelectedPlanet() {
        return selectedPlanet;
    }

    public String changePlanet(String newValue) {
        selectedPlanet = newValue;
        return selectedPlanet;
    }
}
