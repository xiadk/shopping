package com.ZIBShopping.dao;

import com.ZIBShopping.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * zjh 2018.7.3
 */
@Repository
public interface OrderDao extends JpaRepository<OrderDto, Integer> {
    List<OrderDto> findOrderDtosByUserId(Long userId);
}
