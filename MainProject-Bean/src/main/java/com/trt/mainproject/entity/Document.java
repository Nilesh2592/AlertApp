/*
 * 
 */
package com.trt.mainproject.entity;

import java.io.Serializable;
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
@Table(name = "user_document")
public class Document implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "user_file",length = 999999)
    private byte[] userFile;

    public Document() {
    }

    public Document(int id, String fileName, byte[] userFile) {
        this.id = id;
        this.fileName = fileName;
        this.userFile = userFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getUserFile() {
        return userFile;
    }

    public void setUserFile(byte[] userFile) {
        this.userFile = userFile;
    }
}
