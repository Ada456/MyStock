package com.ww.model;

import com.sun.jdi.IntegerType;

import java.io.Serializable;
import java.util.List;

/**
 * 角色 .
 */

public class Role implements Serializable {

    private static final long serialVersionUID = 4885844841260250780L;

    /**
     * 角色Id
     */
    private Integer roleid;
    /**
     * 角色名
     */
    private String rolename;

    /**
     * 角色状态
     */
    private Integer state;

    /**
     * 角色说明
     */
    private String bz;


    /**
     * default constructor
     */
    public Role() {
    }

    public Role(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * minimal constructor
     */
    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Role(Integer roleid, String rolename, Integer state, String bz) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.state = state;
        this.bz = bz;
    }

    /**
     * full constructor
     */
    public Role(String rolename, String bz,Integer state) {
        this.rolename = rolename;
        this.bz = bz;
        this.state = state;
    }

    // Property accessors

    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}