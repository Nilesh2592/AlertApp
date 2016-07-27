/*
 * This is Teacher Bean Class.
 */
package com.trt.mainproject.bean;

/**
 *
 * @author nilay
 */
public class Teacher {

    private long Id;
    private String uname;
    private String name;
    private String pass;
    private String mobile;

    public Teacher() {
    }

    public Teacher(long Id, String uname, String name, String pass, String mobile) {
        this.Id = Id;
        this.uname = uname;
        this.name = name;
        this.pass = pass;
        this.mobile = mobile;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
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

    @Override
    public String toString() {
        return "Teacher{" + "Id=" + Id + ", uname=" + uname + ", name=" + name
                + ", pass=" + pass + ", mobile=" + mobile + '}';
    }

}
