/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.util.Objects;


public class HealthPlan {
    
    private String planName;
    private double premium;
    private String number;

    public HealthPlan(String planName, double premium, String number) {
        this.planName = planName;
        this.premium = premium;
        this.number = number;
    }
    public boolean isEmpty() {
        if(planName == null)
            return true;
        else
            return false;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HealthPlan other = (HealthPlan) obj;
        if (Double.doubleToLongBits(this.premium) != Double.doubleToLongBits(other.premium)) {
            return false;
        }
        if (!Objects.equals(this.planName, other.planName)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

    
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    
    public String getPlanName() {
        return planName;
    }

    public double getPremium() {
        return premium;
    }

    public String getNumber() {
        return number;
    }

    
    
    
}
