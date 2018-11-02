package com.ftkj.ccgl.model;

import java.io.Serializable;


public class Good implements Serializable{
    private Integer id;

    private String goodname;

    private Integer goodcategoriesid;
    
    private String goodcategoriesTest;


    private String note;
    

	public String getGoodcategoriesTest() {
		return goodcategoriesTest;
	}

	public void setGoodcategoriesTest(String goodcategoriesTest) {
		this.goodcategoriesTest = goodcategoriesTest;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public Integer getGoodcategoriesid() {
        return goodcategoriesid;
    }

    public void setGoodcategoriesid(Integer goodcategoriesid) {
        this.goodcategoriesid = goodcategoriesid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	@Override
	public String toString() {
		return "Good [id=" + id + ", goodname=" + goodname + ", goodcategoriesid=" + goodcategoriesid
				+ ", goodcategoriesTest=" + goodcategoriesTest + ", note=" + note + "]";
	}
    
    
}