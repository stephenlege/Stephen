/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.Queries;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author KIDSCOMPUTER
 */
@Named(value = "queryBean")
@RequestScoped
public class QueryBean {

    private Queries queries;
    List<String> table;
    String tableName;
    List<String> projectionFields;
    Map<String, String> whereFieldsNValues = new LinkedHashMap<>();
    List<String> operators;
    String fields;
    String where;
    String ops;

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }
    
    public QueryBean() { queries = new Queries();}

    public Queries getQueries() {
        return queries;
    }

    public void setQueries(Queries queries) {
        this.queries = queries;
    }

    public List<String> getProjectionFields() {
        return projectionFields;
    }

    public void setProjectionFields(List<String> projectionFields) {
        this.projectionFields = projectionFields;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Map<String, String> getWhereFieldsNValues() {
        return whereFieldsNValues;
    }

    public void setWhereFieldsNValues(Map<String, String> whereFieldsNValues) {
        this.whereFieldsNValues = whereFieldsNValues;
        
    }
    
    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }

    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getTable() {
        return table;
    }
    public void setVars(String fields, String ops, String where){
        projectionFields = new ArrayList<>(Arrays.asList(fields.trim().split(" ")));
        operators = new ArrayList<>(Arrays.asList(ops.trim().split(" ")));
        List<String> map = new ArrayList<>(Arrays.asList(where.trim().split(" ")));
        for(int i = 0; i < map.size(); i+=2){
            whereFieldsNValues.put(map.get(i), map.get(i + 1));
        }
        
    }
    public void queries(){
        setVars(fields, ops, where);
        if (!tableName.isEmpty()){
            if(queries.isTable(tableName))
                table = queries.selectAllFromTableWhereFields(tableName, projectionFields, whereFieldsNValues, operators);
            else{
                table = new ArrayList();
                table.add("Table " + tableName + " doesn't exist in the database.");
            }
        }
        else{
            table = new ArrayList();
            table.add("No name for table?");
        }
    }
    
}
