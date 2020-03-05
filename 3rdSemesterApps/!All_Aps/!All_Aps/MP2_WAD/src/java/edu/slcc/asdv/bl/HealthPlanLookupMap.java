/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KIDSCOMPUTER
 */
public class HealthPlanLookupMap implements HealthPlanFinder{
    
    private Map<String, HealthPlan> healthPlans;
    
    public HealthPlanLookupMap(){
        healthPlans = new HashMap<>();
        addHealthPlan(new HealthPlan("stealallyourmoney", 1000000000.00, "(337)444-2220"));
        addHealthPlan(new HealthPlan("bloodpoisonslittlehelper", 100.00, "(555)655-5555"));
        addHealthPlan(new HealthPlan("youdead", 1.00, "(337)YOU-DEAD"));
    }

    @Override
    public HealthPlan findHealthPlan(String name) {
        if (name != null){
            return (healthPlans.get(name.toLowerCase()));
        }
        else
            return null;
    }
    
    private void addHealthPlan(HealthPlan healthPlan){
        healthPlans.put(healthPlan.getPlanName(), healthPlan);
    }
}
