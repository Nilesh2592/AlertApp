/*
 * 
 */
package com.trt.mainproject.entity;

import java.io.Serializable;
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
@Table(name = "teacher_master")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "uname")
    private String uname;

    @Column(name = "name")
    private String name;

    @Column(name = "pass")
    private String pass;

    @Column(name = "mobile")
    private String mobile;

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

    public Teacher() {
    }

    public Teacher(Long id, String uname, String name, String pass, String mobile) {
        this.id = id;
        this.uname = uname;
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
        return "Teacher{" + "id=" + id + ", uname=" + uname + ", name=" + name + ", pass="
                + pass + ", mobile=" + mobile + '}';
    }

}
