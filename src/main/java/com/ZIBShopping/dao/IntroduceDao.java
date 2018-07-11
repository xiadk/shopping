package com.ZIBShopping.dao;

import com.ZIBShopping.dto.IntrodueDto;
import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.enums.Introduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * zjh 2018.7.3
 */
@Repository
public interface IntroduceDao extends JpaRepository<IntrodueDto, Integer> {
    IntrodueDto findIntrodueDtoByName(String name);
}
