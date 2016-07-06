package com.ww.model;

import java.io.Serializable;

/**
 * 用户实体类.
 */

public class User implements Serializable {

    private static final long serialVersionUID = -604451290770954357L;

    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 用户角色
     */
    private Role role;
    /**
     * 用户账号
     */
    private String logincode;

    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户状态
     */
    private Integer state;

    /**
     * 用户说明
     */
    private String bz;

    // Constructors

    /**
     * default constructor
     */
    public User() {
    }

    /**
     * minimal constructor
     */
    public User(Role role, String account, String password, String username,
                Integer state) {
        this.role = role;
        this.logincode = account;
        this.password = password;
        this.username = username;
        this.state = state;
    }

    /**
     * full constructor
     */
    public User(Role role, String logincode, String password, String username,
                Integer state, String bz) {
        this.role = role;
        this.logincode = logincode;
        this.password = password;
        this.username = username;
        this.state = state;
        this.bz = bz;
    }

    /**
     * Property accessors
     */


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogincode() {
        return logincode;
    }

    public void setLogincode(String logincode) {
        this.logincode = logincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}