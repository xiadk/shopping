package com.ZIBShopping.service;

import com.ZIBShopping.dto.ProductDetailsDto;
import com.ZIBShopping.dto.ZIBProductDto;

import java.util.Date;
import java.util.List;

/**
 * zjh 2018.7.2
 */
public interface ProductDetailsService {
    ProductDetailsDto findProductDetailsDto(String productId);
}
