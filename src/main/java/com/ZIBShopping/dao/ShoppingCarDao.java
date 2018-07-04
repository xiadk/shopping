package com.ZIBShopping.dao;

import com.ZIBShopping.dto.ShoppingCarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * zjh 2018.7.2
 */
@Repository
public interface ShoppingCarDao extends JpaRepository<ShoppingCarDto, Integer> {
    List<ShoppingCarDto> findShoppingCarDtosByUserId(String userId);
    void deleteShoppingCarDtoById(Long id);
}
