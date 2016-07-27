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
@Table(name = "admin_master")
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

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

    public Admin() {
    }

    public Admin(Long id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Long getUni_id() {
        return uni_id;
    }

    public void setUni_id(Long uni_id) {
        this.uni_id = uni_id;
    }
    
    
    
    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + '}';
    }
}
