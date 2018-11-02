package com.ftkj.ccgl.model;

import java.io.Serializable;
import java.util.Date;


public class Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//商品信息
    private Integer goodid;
    private Double goodnumber;
    private String goodname;

    ////////入库信息
    private Integer storageid;
    private Double inprice;
    private String storagedate;
    private Double storagenumber;
    private String storagenote;
    private String storageunit;
    
	/////出库信息
    
    private Integer outstockid;
    private Double saleprice;
    private String outstockdate;
    private Double outstocknumber;
    private String outstocknote;
	public Integer getGoodid() {
		return goodid;
	}
	public void setGoodid(Integer goodid) {
		this.goodid = goodid;
	}
	public Double getGoodnumber() {
		return goodnumber;
	}
	public void setGoodnumber(Double goodnumber) {
		this.goodnumber = goodnumber;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public Integer getStorageid() {
		return storageid;
	}
	public void setStorageid(Integer storageid) {
		this.storageid = storageid;
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
		this.storagenote = storagenote;
	}
	public String getStorageunit() {
		return storageunit;
	}
	public void setStorageunit(String storageunit) {
		this.storageunit = storageunit;
	}
	public Integer getOutstockid() {
		return outstockid;
	}
	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
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
		this.outstocknote = outstocknote;
	}

}