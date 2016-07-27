/*
 * This is University Bean Class.
 */
package com.trt.mainproject.bean;

/**
 *
 * @author nilay
 */
public class University {

    private int id;
    private String name;
    private int regno;

    public University() {
    }

    public University(int id, String name, int regno) {
        this.id = id;
        this.name = name;
        this.regno = regno;
    }

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

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    @Override
    public String toString() {
        return "University{" + "id=" + id + ", name=" + name + ", regno=" + regno + '}';
    }

}
