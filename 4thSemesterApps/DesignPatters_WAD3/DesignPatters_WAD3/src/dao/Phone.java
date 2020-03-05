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
public class Phone implements KeyedProduct<String>, Comparable<Phone> {

    private String id;
    private String description;

    public Phone(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final Phone other = (Phone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", description=" + description + '}';
    }

    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public void setKey(String key) {
        setKey(key);
    }

    @Override
    public int compareTo(Phone o) {
        return this.id.compareTo(o.id);
    }

}
