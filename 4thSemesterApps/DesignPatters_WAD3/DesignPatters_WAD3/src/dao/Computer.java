/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Objects;

/**
 *
 * @author LEGE
 */
public class Computer  implements KeyedProduct<Integer>, Comparable<Computer>{
    private Integer id; //key
    private String type;

     // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Computer(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    //</editor-fold>

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
        final Computer other = (Computer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Computer{" + "id=" + id + ", type=" + type + '}';
    }
    

    @Override
    public Integer getKey() {
        return this.getId();
    }

    @Override
    public void setKey(Integer key) {
        this.setId(id);
    }

    @Override
    public int compareTo(Computer o) {
        return this.id.compareTo(o.id);
    }
    
    
}
