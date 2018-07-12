package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.PlaceOfReceiptDao;
import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.ZIBShopping.service.PlaceOfReceiptService;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.1
 */
@Service
public class PlaceOfReceiptServiceImpl implements PlaceOfReceiptService {
    @Autowired
    private PlaceOfReceiptDao placeOfReceiptDao;
    @Override
    public List<PlaceOfReceiptDto> findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(@NotNull Long userId) {
        return placeOfReceiptDao.findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(userId);
    }

    @Override
    public PlaceOfReceiptDto findPlaceOfReceiptDtoById(@NotNull Long id) {
        return placeOfReceiptDao.findPlaceOfReceiptDtoById(id);
    }

    @Transactional
    @Override
    public void deletePlaceOfReceiptDtoById(@NotNull Long id) {
        placeOfReceiptDao.deletePlaceOfReceiptDtoById(id);
    }

    /**
     * 数据库逻辑中存在更新，删除；要加上@Transactional
     * 添加或修改地址，选中当前地址为默认isDefault：true
     * @param placeOfReceiptDto
     * @return
     */
    @Transactional
    @Override
    public PlaceOfReceiptDto save(@NotNull PlaceOfReceiptDto placeOfReceiptDto) {
        placeOfReceiptDao.update(true);
        PlaceOfReceiptDto porDto = placeOfReceiptDao.save(placeOfReceiptDto);
        return porDto;
    }

    @Override
    public Map<String, Object> defaultPlace(Long userId, Boolean isDefault) {
        Map<String,Object> map = new HashMap<>();
        map.put("code","-1");
        PlaceOfReceiptDto place = placeOfReceiptDao.findPlaceOfReceiptDtoByUserIdAndIsDefault(userId,isDefault);
        if(place!=null){
            map.put("place",place);
            map.put("code","1");
        }
        return map;
    }

}
