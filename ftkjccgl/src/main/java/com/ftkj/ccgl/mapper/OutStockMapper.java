package com.ftkj.ccgl.mapper;

import com.ftkj.ccgl.model.OutStock;
import java.util.List;

public interface OutStockMapper {

    int deleteByPrimaryKey(Integer outstockid);
    
    int deleteByPrimaryKeys(List<String> list);


    int insert(OutStock record);

    int insertSelective(OutStock record);

    List<OutStock> selectByOutStock(OutStock record);

    OutStock selectByPrimaryKey(Integer outstockid);


    int updateByPrimaryKeySelective(OutStock record);

    int updateByPrimaryKey(OutStock record);
    
    int maxOutStockId();

    
}