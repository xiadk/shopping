package com.ZIBShopping.dao;

import com.ZIBShopping.dto.PlaceOfReceiptDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * zjh 2018.7.1
 */
@Repository
public interface PlaceOfReceiptDao extends JpaRepository<PlaceOfReceiptDto, Integer> {
    List<PlaceOfReceiptDto> findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(String userId);

    PlaceOfReceiptDto findPlaceOfReceiptDtoById(Long id);

    void deletePlaceOfReceiptDtoById(Long id);
}
