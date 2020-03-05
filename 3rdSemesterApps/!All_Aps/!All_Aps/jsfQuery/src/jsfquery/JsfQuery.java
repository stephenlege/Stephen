/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfquery;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsfQuery {

    public static String inputTableName = "  supplier  ";
    public static String inputProjectionFields = "  snumber sname";
    public static String inputWhereFieldsNValues = " city london status 0     snumber s1";
    public static String inputOperators = "=     >   =";

    private static String tableName = inputTableName.trim();
   
    

    private static String sqlStr = "";

    public static void main(String[] args) {

        List<String> projectionFields = new ArrayList();
        space(inputProjectionFields.trim(), projectionFields);
        print(projectionFields);

        Map<String, String> whereFieldsNValues = new LinkedHashMap();
        spaceMap(inputWhereFieldsNValues.trim(), whereFieldsNValues);
        System.out.println(whereFieldsNValues);

        List<String> operators = new ArrayList();
        space(inputOperators.trim(), operators);
        print(operators);

        sqlStr = "Select " + processProjectionFields(projectionFields) + " FROM " + tableName + " WHERE ";
        System.out.println(sqlStr);
        System.out.println("-----------------------------------------------------------");
        sqlStr += processWhereAndOperators(whereFieldsNValues, operators);
        System.out.println(sqlStr);

    }

  

    /**
     * will take the where clause and operators and process them based on size
     *
     * @param map
     * @param list
     * @return
     */
    public static String processWhereAndOperators(Map<String, String> map, List<String> list) {
        String s = "";
        int getCount = map.size();
        //System.out.println(getCount);
        List<String> keys = new ArrayList(map.keySet());
        List<String> values = new ArrayList(map.values());

//        if (getCount != list.size()) {
//            return replaceSQLString();
//        }

        for (int i = 0; i < getCount; i++) {

            if (i == 0) {
                s += keys.get(i) + " " + list.get(i) + " " + values.get(i) + " AND ";
            } else if (i % 2 == 0) {
                s += " AND " + keys.get(i) + " " + list.get(i) + " " + values.get(i) + " ";
            }
            if (i == getCount - 1) {
                break;
            } else if (i % 2 != 0) {
                s += keys.get(i) + " " + list.get(i) + " " + values.get(i) + " ";
            }

        }

        return s;
    }

    public static String processProjectionFields(List<String> list) {
        String s = "";

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i) + ", ";
            } else {
                s += list.get(i);
            }
        }
        //System.out.println(s);
        return s;
    }

    public List<String> selectFieldsFromTableWhereFields(String tableName,
            List<String> projectionFields, Map<String, String> whereFieldsNValues,
            List<String> operators) {

        return new ArrayList<String>();
    }

    public static void space(String string, List<String> list) {
        String[] stringArray = string.split("\\s+");
        for (String word : stringArray) {
            list.add(word);
        }

    }

    public static void print(List<String> list) {
        for (String word : list) {
            System.out.print(word + " ");
        }
        System.out.println("");
    }

    public static void spaceMap(String string, Map<String, String> map) {
        String[] stringArray = string.split("\\s+");

        for (int i = 0; i < stringArray.length; i++) {
            if (i % 2 != 0) {
                map.put(stringArray[i - 1], stringArray[i]);
            }
        }
    }

}
