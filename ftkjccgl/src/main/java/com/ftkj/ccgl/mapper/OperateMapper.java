package com.ftkj.ccgl.mapper;

import com.ftkj.ccgl.model.Operate;
import java.util.List;

public interface OperateMapper {

    List<Operate> selectByOperate(Operate record);
    
    int insert(Operate record);
    
    int deleteByPrimaryKeys(List<String> list);

}