/*
 * This is admin bean class.
 */
package com.trt.mainproject.bean;

/**
 *
 * @author nilay
 */
public class Admin {

    private int id;
    private String uname;
    private String pass;
    private String email;
    private long mob;

    public Admin() {
    }

    public Admin(int id, String uname, String pass, String email, long mob) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.email = email;
        this.mob = mob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMob() {
        return mob;
    }

    public void setMob(long mob) {
        this.mob = mob;
    }

    @Override
    public String toString() {
        return "AddAdmin{" + "id=" + id + ", uname=" + uname + ", pass=" + pass
                + ", email=" + email + ", mob=" + mob + '}';
    }

}
