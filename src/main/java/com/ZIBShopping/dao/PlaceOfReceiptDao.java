package com.ZIBShopping.dao;

import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * zjh 2018.7.1
 */
@Repository
public interface PlaceOfReceiptDao extends JpaRepository<PlaceOfReceiptDto, Integer> {
    List<PlaceOfReceiptDto> findPlaceOfReceiptDtosByTokenOrderByUpdateTimeDesc(String token);

    PlaceOfReceiptDto findPlaceOfReceiptDtoById(Long id);

    void deletePlaceOfReceiptDtoById(Long id);
    @Query(value = "UPDATE zib_place_of_receipt SET is_default = false WHERE is_default = :isDefault",nativeQuery=true)
    void update(Boolean isDefault);
}
