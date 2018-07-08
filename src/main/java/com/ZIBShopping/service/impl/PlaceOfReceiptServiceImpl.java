package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.PlaceOfReceiptDao;
import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.ZIBShopping.service.PlaceOfReceiptService;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * zjh 2018.7.1
 */
@Service
public class PlaceOfReceiptServiceImpl implements PlaceOfReceiptService {
    @Autowired
    private PlaceOfReceiptDao placeOfReceiptDao;
    @Override
    public List<PlaceOfReceiptDto> findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(@NotNull String token) {
        token = SqlInjectUtils.transactSQLInjection(token);
        return placeOfReceiptDao.findPlaceOfReceiptDtosByTokenOrderByUpdateTimeDesc(token);
    }

    @Override
    public PlaceOfReceiptDto findPlaceOfReceiptDtoById(@NotNull Long id) {
        return placeOfReceiptDao.findPlaceOfReceiptDtoById(id);
    }

    @Override
    public void deletePlaceOfReceiptDtoById(@NotNull Long id) {
        placeOfReceiptDao.deletePlaceOfReceiptDtoById(id);
    }

    @Override
    public PlaceOfReceiptDto save(@NotNull PlaceOfReceiptDto placeOfReceiptDto) {
        placeOfReceiptDao.update(true);
        PlaceOfReceiptDto porDto = placeOfReceiptDao.save(placeOfReceiptDto);
        return porDto;
    }

}
