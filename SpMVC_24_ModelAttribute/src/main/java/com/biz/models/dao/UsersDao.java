package com.biz.models.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.biz.models.domain.UsersVO;

public interface UsersDao {

	@Select("SELECT * FROM TBL_USER WHERE UserId = #{userId}")
	public UsersVO findByUserId(String userId);

	@Insert(
			" INSERT INTO tbl_user " + 
			" (userId, " + 
			" password, " + 
			" userName, " + 
			" userRolle " + 
			" )VALUES( " + 
			" #{userId}, " + 
			" #{password}, " + 
			" #{userName}, " + 
			" #{userRolle}) " )
	public int insert(UsersVO userVO); 
	
	@Delete("DELETE FROM TBL_USER WHERE userId = #{userId}")
	public int delete(String userId); 
	
}
