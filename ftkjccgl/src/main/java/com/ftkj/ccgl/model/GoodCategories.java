package com.ftkj.ccgl.model;

import java.io.Serializable;


public class GoodCategories implements Serializable{
    private Integer id;

    private String goodname;

    private String description;
    

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public String toString() {
		return "GoodCategories [id=" + id + ", goodname=" + goodname + ", description=" + description + "]";
	}
    
}