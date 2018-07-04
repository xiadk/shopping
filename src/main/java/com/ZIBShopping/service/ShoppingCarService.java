package com.ZIBShopping.service;

import com.ZIBShopping.dto.ShoppingCarDto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * zjh 2018.7.3
 */
public interface ShoppingCarService {
    List<ShoppingCarDto> findShoppingCarDtos(@NotNull String userId);
    void deleteShoppingCarDto(Long id);
    ShoppingCarDto save(ShoppingCarDto shoppingCarDto);
}
