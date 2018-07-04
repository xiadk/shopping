package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.ShoppingCarDao;
import com.ZIBShopping.dto.ShoppingCarDto;
import com.ZIBShopping.service.ShoppingCarService;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * zjh 2018.7.3
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    private ShoppingCarDao shoppingCarDao;
    @Override
    public List<ShoppingCarDto> findShoppingCarDtos(String userId) {
        boolean flag = SqlInjectUtils.sql_inj(userId);
        if (flag) {
            return null;
        }
        return shoppingCarDao.findShoppingCarDtosByUserId(userId);
    }

    @Override
    public void deleteShoppingCarDto(Long id) {
        shoppingCarDao.deleteShoppingCarDtoById(id);
    }

    @Override
    public ShoppingCarDto save(ShoppingCarDto shoppingCarDto) {
        return shoppingCarDao.save(shoppingCarDto);
    }
}
