package com.ftkj.ccgl.mapper;

import com.ftkj.ccgl.model.Storage;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {


    int deleteByPrimaryKey(Integer id);
    
    int deleteByPrimaryKeys(List<String> list);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
    
    List<Storage> selectByStorage(Storage record);
    
    int seleMaxId();

}