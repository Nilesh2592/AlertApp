/*
 * 
 */
package com.trt.mainproject.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nilay
 */
@Entity
@Table(name = "alert_master")
public class Alert {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "aid")
    private int aid;

    @Column(name = "msg")
    private String msg;

    @Column(name = "uni_id")
    private Long uni_id;

    @Column(name = "created_date")
    private Date crDate;

    @Column(name = "updated_date")
    private Date update;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "isarchive")
    private Boolean isArchive;

    public Alert() {
    }

    public Alert(Long id, int aid, String msg) {
        this.id = id;
        this.aid = aid;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getUni_id() {
        return uni_id;
    }

    public void setUni_id(Long uni_id) {
        this.uni_id = uni_id;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    @Override
    public String toString() {
        return "Alert{" + "id=" + id + ", aid=" + aid + ", msg=" + msg + '}';
    }

}
