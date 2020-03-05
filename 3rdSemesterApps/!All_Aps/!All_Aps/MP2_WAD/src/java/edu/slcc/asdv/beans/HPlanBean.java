/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.HealthPlanFinder;
import edu.slcc.asdv.bl.HealthPlanLookupMap;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import edu.slcc.asdv.bl.HealthPlan;
/**
 *
 * @author Greg
 */
@Named(value = "hPlanBean")
@RequestScoped
public class HPlanBean {

    private String name;
    private String id;
    private String healthPlan;
    private Double premium;
    private String number;
    private String outputHealthPlan;

    private HealthPlan hp;
    private static HealthPlanFinder healthPlanFinder = new HealthPlanLookupMap();

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public String getOutputHealthPlan() {
        return outputHealthPlan;
    }

    public void setOutputHealthPlan(String outputHealthPlan) {
        this.outputHealthPlan = outputHealthPlan;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    
    public Double getPremium() {
        return premium;
    }

    public String getNumber() {
        return number;
    }

    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getHealthPlan() {
        return healthPlan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHealthPlan(String healthPlan) {
        this.healthPlan = healthPlan;
    }

    /**public Employee getEmployee() {
        return employee;
    }*/
     public double getPlanPremium(){
        hp = healthPlanFinder.findHealthPlan(healthPlan);
        return hp.getPremium();
    }
     
     public HealthPlan getHp(){
         return hp;
     }
     
    
    public String getPlanNumber(){
        hp = healthPlanFinder.findHealthPlan(healthPlan);
        return hp.getNumber();
    }
    

    //Employee employee = new Employee(name, id, healthPlan);

    public String directToHPlan() {
        try {
            if (name.isEmpty()
                    || id.isEmpty() || healthPlan.isEmpty()) {
                return "missingInput";
            } else {
                return "healthPlan1";
            }
        } catch (Exception ex) {
            return "";
        }

    }

    public String searchHPlan() {
        try {
            if (name.isEmpty() || id.isEmpty() ) {
                return ("missingInput");
            }
            hp = healthPlanFinder.findHealthPlan(healthPlan);
            if (hp == null) {
                return ("wrongHP");
            } else {
                setOutputHealthPlan(hp.getPlanName());
                setPremium(hp.getPremium());
                setNumber(hp.getNumber());
                return ("healthPlan2");
            }
        } catch (Exception ex) {
            return "";}
    }
}
