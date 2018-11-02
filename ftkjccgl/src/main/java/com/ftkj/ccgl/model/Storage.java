package com.ftkj.ccgl.model;

import java.io.Serializable;
import java.util.Date;


public class Storage implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2547422011757723329L;

	private Integer id;

    private Integer goodid;

    private Double inprice;

    private String storagedate;

    private Double storagenumber;

    private String storagenote;

    private String storageunit;
    
    private String goodname;
    
    private Double addNumber;
    

    public Double getAddNumber() {
		return addNumber;
	}

	public void setAddNumber(Double addNumber) {
		this.addNumber = addNumber;
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

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public String getStoragedate() {
        return storagedate;
    }

    public void setStoragedate(String storagedate) {
        this.storagedate = storagedate;
    }

    public Double getStoragenumber() {
        return storagenumber;
    }

    public void setStoragenumber(Double storagenumber) {
        this.storagenumber = storagenumber;
    }

    public String getStoragenote() {
        return storagenote;
    }

    public void setStoragenote(String storagenote) {
        this.storagenote = storagenote == null ? null : storagenote.trim();
    }

    public String getStorageunit() {
        return storageunit;
    }

    public void setStorageunit(String storageunit) {
        this.storageunit = storageunit == null ? null : storageunit.trim();
    }

}