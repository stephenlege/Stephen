/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.util.Objects;
import java.util.logging.Logger;




public class Employee {

   private  String name;
   private  String id;
   private  String healthPlan;
   

  
   
    public Employee(String id, String healthPlan) {
        this.id = id;
        this.healthPlan = healthPlan;
    }
   

    public Employee(String name, String id, String healthPlan) {
        this.name = name;
        this.id = id;
        this.healthPlan = healthPlan;
    }
    
    public boolean isEmpty() {
        if(name == null || id == null || healthPlan == null)
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.healthPlan, other.healthPlan)) {
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", healthPlan=" + healthPlan + '}';
    }
   
    
   
    
}
