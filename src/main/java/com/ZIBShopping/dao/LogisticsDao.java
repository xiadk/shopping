package com.ZIBShopping.dao;

import com.ZIBShopping.dto.IntrodueDto;
import com.ZIBShopping.dto.LogisticsDto;
import com.ZIBShopping.enums.Introduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * zjh 2018.7.3
 */
@Repository
public interface LogisticsDao extends JpaRepository<LogisticsDto, Integer> {
    LogisticsDto findLogisticsDtoById(Long id);
}
