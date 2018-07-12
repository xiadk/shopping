package com.ZIBShopping.service;

import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.1
 */
public interface PlaceOfReceiptService {
    List<PlaceOfReceiptDto> findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(Long userId);
    PlaceOfReceiptDto findPlaceOfReceiptDtoById(Long id);
    void deletePlaceOfReceiptDtoById(Long id);
    PlaceOfReceiptDto save(PlaceOfReceiptDto placeOfReceiptDto);

    /**
     * 默认地址
     * @param userId
     * @param isDefault
     * @return
     */
    Map<String,Object> defaultPlace(Long userId, Boolean isDefault);
}
