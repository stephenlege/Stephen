/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.Queries;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Greg
 */
@Named(value = "selectBean")
@ApplicationScoped

public class SelectBean {

    private Queries selectQuery;

    public SelectBean() {

        selectQuery = new Queries();
    }
    List<String> table;

    String inputTableName;
    String inputProjectionFields;
    String inputWhereFieldsNValues;
    String inputOperators;

    String tableName;
    List<String> projectionFields;
    Map<String, String> whereFieldsNValues;
    List<String> operators;
    List<String> keys;

    public void process() {
        tableName = inputTableName.trim();
        projectionFields = new ArrayList();
        whereFieldsNValues = new LinkedHashMap();
        operators = new ArrayList();

        space(inputProjectionFields.trim(), projectionFields);
        spaceMap(inputWhereFieldsNValues.trim(), whereFieldsNValues);
        space(inputOperators.trim(), operators);
        keys = new ArrayList(whereFieldsNValues.keySet());

    }

    public void spaceMap(String string, Map<String, String> map) {
        String[] stringArray = string.split("\\s+");

        for (int i = 0; i < stringArray.length; i++) {
            if (i % 2 != 0) {
                map.put(stringArray[i - 1], stringArray[i]);
            }
        }
    }

    public void space(String string, List<String> list) {
        String[] stringArray = string.split("\\s+");
        for (String word : stringArray) {
            list.add(word);
        }

    }

    public String getTableName() {
        return tableName;
    }

    public List<String> getProjectionFields() {
        return projectionFields;
    }

    public Map<String, String> getWhereFieldsNValues() {
        return whereFieldsNValues;
    }

    public List<String> getOperators() {
        return operators;
    }

    public Queries getSelectQuery() {
        return selectQuery;
    }

    public String getInputTableName() {
        return inputTableName;
    }

    public String getInputProjectionFields() {
        return inputProjectionFields;
    }

    public String getInputWhereFieldsNValues() {
        return inputWhereFieldsNValues;
    }

    public String getInputOperators() {
        return inputOperators;
    }

    public void setInputTableName(String inputTableName) {
        this.inputTableName = inputTableName;

    }

    public void setInputProjectionFields(String inputProjectionFields) {
        this.inputProjectionFields = inputProjectionFields;
    }

    public void setInputWhereFieldsNValues(String inputWhereFieldsNValues) {
        this.inputWhereFieldsNValues = inputWhereFieldsNValues;
    }

    public void setInputOperators(String inputOperators) {
        this.inputOperators = inputOperators;
    }

    public List<String> getTable() {
        return table;
    }
////////////////////////////////table = selectQuery.selectFieldsFromTableWhereFields(tableName, projectionFields, whereFieldsNValues, operators);
    public void selectQuery() {
        process();
        if (!inputTableName.isEmpty()) {
            if (selectQuery.isTable(inputTableName)) {
            table = selectQuery.selectFieldsFromTableWhereFields(tableName, projectionFields, whereFieldsNValues, operators);    
            
//                if (selectQuery.isFields(projectionFields)) {
//                    table = selectQuery.selectFieldsFromTableWhereFields(tableName, projectionFields, whereFieldsNValues, operators);
//                } else {
//                    table = new ArrayList();
//                    table.add("One or more of the fields: " + inputProjectionFields.trim() + " do not EXIST");
//                }
            } 
                else {
                table = new ArrayList();
                table.add("Table " + inputTableName + " doesn't exist in the database");
            }
        } else {
            table = new ArrayList();
            table.add("No name for table");
        }
    }

}
