package com.ZIBShopping.service;

import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.ZIBShopping.dto.ZIBProductDto;

import java.util.Date;
import java.util.List;

/**
 * zjh 2018.7.2
 */
public interface ZIBProductService {
    List<ZIBProductDto> findPage(Date updateTime, Long row);
}
