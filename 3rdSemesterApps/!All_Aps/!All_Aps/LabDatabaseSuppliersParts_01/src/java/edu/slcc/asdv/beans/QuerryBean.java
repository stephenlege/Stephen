/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.Queries;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "querryBean")
@ApplicationScoped
public class QuerryBean {

    private Queries queries;
    List<String> table;

    String tableName;

    public List<String> getTable() {
        return table;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public QuerryBean() {

        queries = new Queries();
    }

    public void queries() {
        if (!tableName.isEmpty()) {
            if (queries.isTable(tableName)) {
                table = queries.selectAllFromTable(tableName);
            } else {
                table = new ArrayList();
                table.add("Table " + tableName + " doesn't exist in the database");
            }
        } else {
            table = new ArrayList();
            table.add("No name for table?");
        }
    }

}
