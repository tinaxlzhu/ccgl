package com.ftkj.ccgl.mapper;

import com.ftkj.ccgl.model.Stock;
import java.util.List;

public interface StockMapper {

    int deleteByPrimaryKey(Integer stockid);

    int insert(Stock record);

    List<Stock> selectByStock(Stock record);

    Stock selectByPrimaryKey(Integer stockid);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
    
    int updateByByGoodIdAndStorageid(Stock record);
    
    Stock selectByGoodIdAndStorageid(Stock record);
}