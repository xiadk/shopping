package com.ZIBShopping.dao;

import com.ZIBShopping.dto.ZIBProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * zjh 2018.7.2
 */
@Repository
public interface ZIBProductDao extends JpaRepository<ZIBProductDto, Integer> {
    @Query(value = "select * from zib_product z where update_time<:update_time order by update_time desc limit :row", nativeQuery = true)
    List<ZIBProductDto> findZIBProductDtos(@Param("update_time") String updateTime, @Param("row") Long row);

    @Query(value = "select * from zib_product z  order by sales_count desc limit :amount ", nativeQuery = true)
    ZIBProductDto findZIBProductDto(@Param("amount") Long count);
}
