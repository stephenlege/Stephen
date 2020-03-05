/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import edu.slcc.asdv.pojos.*;
import java.util.Map;

/**
 *
 * @author KIDSCOMPUTER
 */
@Named(value = "city")
@RequestScoped
public class CityBean {

    String city = "Baltimore";
    String value;
    City cities = new City();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public City getCities() {
        return cities;
    }
    
    public String print(){
        return "City: " + city + ", Teams: " + cities.cityMap.get(city);
    }
}
