package com.ZIBShopping.dao;

import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.enums.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * zjh 2018.7.3
 */
@Repository
public interface OrderDao extends JpaRepository<OrderDto, Integer> {
    List<OrderDto> findOrderDtosByUserIdAndStatusValue(Long userId, String statusValue);
    @Modifying
    @Query(value = "UPDATE zib_order SET status_value = :status ,status = :val WHERE id = :id",nativeQuery=true)
    void update(@Param("id")Long id,@Param("status") String status,@Param("val")Long val);

    OrderDto findOrderDtoById(Long id);
}
