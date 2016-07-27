/*
 * this is Alert Bean Class.
 */
package com.trt.mainproject.bean;

/**
 *
 * @author nilay
 */
public class Alert {

    private int id;
    private int aId;
    private String aMessage;

    public Alert() {
    }

    public Alert(int id, int aId, String aMessage) {
        this.id = id;
        this.aId = aId;
        this.aMessage = aMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaMessage() {
        return aMessage;
    }

    public void setaMessage(String aMessage) {
        this.aMessage = aMessage;
    }

    @Override
    public String toString() {
        return "Alert{" + "id=" + id + ", aId=" + aId + ", aMessage=" + aMessage + '}';
    }

}
