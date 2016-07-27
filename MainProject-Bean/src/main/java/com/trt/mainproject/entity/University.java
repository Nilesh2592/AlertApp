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
@Table(name = "uni_master")
public class University {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "regno")
    private String regno;
    
    @Column(name = "created_date")
    private Date crDate;

    @Column(name = "updated_date")
    private Date update;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "isarchive")
    private Boolean isArchive;

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
    
    
    
    public University() {
    }

    public University(Long id, String name, String regno) {
        this.id = id;
        this.name = name;
        this.regno = regno;
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

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    
    @Override
    public String toString() {
        return "University{" + "id=" + id + ", name=" + name + ", regno=" + regno + '}';
    }
}
