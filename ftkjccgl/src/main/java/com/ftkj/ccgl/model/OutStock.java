package com.ftkj.ccgl.model;

import java.io.Serializable;
import java.util.Date;


public class OutStock implements Serializable{
    private Integer outstockid;

    private Integer goodid;

    private Double saleprice;

    private String outstockdate;

    private Double outstocknumber;

    private String outstocknote;

    private String quarter;

    private Integer storageid;
    
    private String storagenote;
    
    private String goodname;
    
    
    private Double addNumber;

	public Double getAddNumber() {
		return addNumber;
	}

	public void setAddNumber(Double addNumber) {
		this.addNumber = addNumber;
	}

	public String getStoragenote() {
		return storagenote;
	}

	public void setStoragenote(String storagenote) {
		this.storagenote = storagenote;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public Integer getOutstockid() {
        return outstockid;
    }

    public void setOutstockid(Integer outstockid) {
        this.outstockid = outstockid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public String getOutstockdate() {
        return outstockdate;
    }

    public void setOutstockdate(String outstockdate) {
        this.outstockdate = outstockdate;
    }

    public Double getOutstocknumber() {
        return outstocknumber;
    }

    public void setOutstocknumber(Double outstocknumber) {
        this.outstocknumber = outstocknumber;
    }

    public String getOutstocknote() {
        return outstocknote;
    }

    public void setOutstocknote(String outstocknote) {
        this.outstocknote = outstocknote == null ? null : outstocknote.trim();
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter == null ? null : quarter.trim();
    }

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }
}