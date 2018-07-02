package com.ZIBShopping.service;

import com.ZIBShopping.dto.PlaceOfReceiptDto;

import java.util.List;

/**
 * zjh 2018.7.1
 */
public interface PlaceOfReceiptService {
    List<PlaceOfReceiptDto> findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(String userId);
    PlaceOfReceiptDto findPlaceOfReceiptDtoById(Long id);
    void deletePlaceOfReceiptDtoById(Long id);
    PlaceOfReceiptDto save(PlaceOfReceiptDto placeOfReceiptDto);
}
