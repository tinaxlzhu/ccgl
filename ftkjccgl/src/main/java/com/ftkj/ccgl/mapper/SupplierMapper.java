package com.ftkj.ccgl.mapper;

import com.ftkj.ccgl.model.Supplier;

import java.util.List;

public interface SupplierMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectSuppliers(Supplier record);

    Supplier selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
    
    int deleteByPrimaryKeys(List<Integer> ids);
    
    List<Supplier> findSuppliersByPage(Supplier supplier);

}