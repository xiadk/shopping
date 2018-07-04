package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.ProductDetailsDao;
import com.ZIBShopping.dao.ZIBProductDao;
import com.ZIBShopping.dto.ProductDetailsDto;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.ProductDetailsService;
import com.ZIBShopping.service.ZIBProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * zjh 2018.7.2
 */
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
    @Autowired
    private ProductDetailsDao productDetailsDao;
    @Override
    public ProductDetailsDto findProductDetailsDto(@NotNull Long productId) {
        return productDetailsDao.findProductDetailsDtoByProductId(productId);
    }
}
