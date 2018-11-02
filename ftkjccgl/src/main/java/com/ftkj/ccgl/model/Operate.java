package com.ftkj.ccgl.model;

import java.io.Serializable;
import java.util.Date;


public class Operate implements Serializable{
    private Integer id;

    private Integer userid;
    
    private String username;

    private Date operatetime;

    private Integer operatetype;

    private String remark;

    private Integer goodid;

    private Integer storageid;
    
    private String goodname;
    
    private String operateTypetest;
    
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOperateTypetest() {
		return operateTypetest;
	}

	public void setOperateTypetest(String operateTypetest) {
		this.operateTypetest = operateTypetest;
	}


    public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public Integer getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Integer operatetype) {
        this.operatetype = operatetype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }
}