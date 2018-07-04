package com.ZIBShopping.dao;

import com.ZIBShopping.dto.ProductDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * zjh 2018.7.2
 */
@Repository
public interface ProductDetailsDao extends JpaRepository<ProductDetailsDto, Integer> {
    ProductDetailsDto findProductDetailsDtoByProductId(Long productId);
}
