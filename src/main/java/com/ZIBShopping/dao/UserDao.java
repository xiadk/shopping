package com.ZIBShopping.dao;

import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * zjh 2018.7.3
 */
@Repository
public interface UserDao extends JpaRepository<UserDto, Integer> {
//    @Query(value="select * from zib_user where openid=:openid")
    UserDto findUserDtoByOpenid( String openid);
}
