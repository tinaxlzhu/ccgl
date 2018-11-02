package com.ftkj.ccgl.mapper;
import com.ftkj.ccgl.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /////////////////////////////////////////
    @Select("select * from t_user where id=#{id}")
	public User getUserById(Integer id);
	
	/**
	 * 多个参数时候一定要添加@Param，否则无法绑定参数
	 * @param userName
	 * @param password
	 * @return
	 */
	@Select("select * from t_user where userName=#{userName} and password=#{password}")
	public User getUserByNamePwd(@Param("userName") String userName,@Param("password") String password);
}