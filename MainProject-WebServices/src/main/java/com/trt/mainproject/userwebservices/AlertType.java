/*
 * 
 */
package com.trt.mainproject.userwebservices;

import org.springframework.stereotype.Repository;

/**
 *
 * @author nilay
 */
@Repository
public class AlertType {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlertType{" + "id=" + id + ", name=" + name + '}';
    }

    public AlertType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AlertType() {
    }
    
}
