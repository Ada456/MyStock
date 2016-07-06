package com.ww.model;


import java.io.Serializable;
import java.util.List;

/**
 * Menu entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Menu implements Serializable {

	// Fields

	/**目录Id*/
	private Integer menuid;
	/**目录名*/
	private String menuname;
	/**父目录id*/
	private Integer pid;
	/**目录URL*/
	private String menuurl;
	/**目录类型*/
	private Integer menutype;
	/**目录序号*/
	private Integer ordernum;
	/**目录图标*/
	private String icon;
	/**
	 * 角色列表
	 */
	private List<Role> roles;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	public Menu(Integer menuid) {
		super();
		this.menuid = menuid;
	}

	/** minimal constructor */
	public Menu(String menuname, Integer menutype) {
		this.menuname = menuname;
		this.menutype = menutype;
	}

	public Menu(Integer menuid, String menuname, Integer pid, String menuurl, Integer menutype, Integer ordernum, String icon, List<Role> roles) {
		this.menuid = menuid;
		this.menuname = menuname;
		this.pid = pid;
		this.menuurl = menuurl;
		this.menutype = menutype;
		this.ordernum = ordernum;
		this.icon = icon;
		this.roles = roles;
	}

	/** full constructor */
	public Menu(String menuname, Integer pid, String menuurl, Integer menutype,
			Integer ordernum, String icon) {
		this.menuname = menuname;
		this.pid = pid;
		this.menuurl = menuurl;
		this.menutype = menutype;
		this.ordernum = ordernum;
		this.icon = icon;
	}
	
	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Menu) ) return false;
		 Menu func = (Menu) other; 
		 return this.getMenuid()==func.getMenuid();
	}

	// Property accessors

	public Integer getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getMenuurl() {
		return this.menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public Integer getMenutype() {
		return this.menutype;
	}

	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}