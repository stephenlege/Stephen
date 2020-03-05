/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.Company;
import edu.slcc.asdv.pojos.Employee;
import edu.slcc.asdv.pojos.Name;
import java.util.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "employeeBean")
@RequestScoped
public class EmployeeBean{

   ArrayList<Employee> dataArrayList = new ArrayList<>();
   Map<String, Employee> dataHashMap = new HashMap<>();
   Map<String, Employee> dataHashMapCovertedToCollection = new HashMap<>();
   TreeMap<String,Employee> dataTreeMap = new TreeMap<>();
   HashSet<Employee> dataHashSet = new HashSet<>();
   TreeSet<Employee> dataTreeSet = new TreeSet<>();

    public ArrayList<Employee> getDataArrayList() {
        return dataArrayList;
    }
    public Map<String, Employee> getDataHashMap() {
        return dataHashMap;
    }
    public Collection<Employee> getDataHashMapCovertedToCollection() { //can convert any map into a Collection like this
        return dataHashMapCovertedToCollection.values();
    }
    public TreeMap<String, Employee> getDataTreeMap() {
        return dataTreeMap;
    }
    public HashSet<Employee> getDataHashSet() {
        return dataHashSet;
    }
    public TreeSet<Employee> getDataTreeSet() {
        return dataTreeSet;
    }

    public EmployeeBean() {
        Employee e1 = new Employee(
                                    new Name("jan", "Databaseux"),
                                    new Company("DBaseSoft.com", "Developing Database Solutions")
        );
        
        Employee e2 = new Employee(
                                    new Name("Anna", "Android"),
                                    new Company("Mobile.com", "Developing Android Solutions")
        );
        
        Employee e3 = new Employee(
                                    new Name("Nick", "Web"),
                                    new Company("WebDevelopment.com", "Developing Web Solutions")
        );
        
        dataArrayList.add(e1);
        dataArrayList.add(e2);
        dataArrayList.add(e3);
        
        dataHashMap.put("key1", e1);
        dataHashMap.put("key2", e2);
        dataHashMap.put("key3", e3);
        
        dataHashMapCovertedToCollection.put("key1", e1);
        dataHashMapCovertedToCollection.put("key2", e2);
        dataHashMapCovertedToCollection.put("key3", e3);
        
        dataTreeMap.put("yellow", e1);
        dataTreeMap.put("black", e2);
        dataTreeMap.put("green", e3);
        
        dataHashSet.add(e1);
        dataHashSet.add(e2);
        dataHashSet.add(e3);
        
        
        dataTreeSet.add(e1);
        dataTreeSet.add(e2);
        dataTreeSet.add(e3);
    }
   
   
   
}
