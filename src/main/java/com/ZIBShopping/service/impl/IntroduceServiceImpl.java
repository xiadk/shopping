package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.IntroduceDao;
import com.ZIBShopping.dao.OrderDao;
import com.ZIBShopping.dto.IntrodueDto;
import com.ZIBShopping.dto.OrderDto;
import com.ZIBShopping.enums.Introduce;
import com.ZIBShopping.service.IntroduceService;
import com.ZIBShopping.service.OrderService;
import com.ZIBShopping.utils.ImgUrlUtils;
import com.ZIBShopping.utils.SqlInjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.2
 */
@Service
public class IntroduceServiceImpl implements IntroduceService {
    @Autowired
    private IntroduceDao introduceDao;
    @Override
    public List<String> find(Introduce introduce) {
        IntrodueDto introdueDto = introduceDao.findIntrodueDtoByName(introduce.toString());
        List<String> imgs = ImgUrlUtils.analysis(introdueDto.getImgUrl(),";");
        return imgs;
    }

    @Override
    public Map<String, List<String>> findAll() {
        List<IntrodueDto> lists = introduceDao.findAll();
        Map<String, List<String>> maps = new HashMap<>();
        for(IntrodueDto list:lists){
            List<String> list1 = ImgUrlUtils.analysis(list.getImgUrl(),";");
            maps.put(list.getName().toString(),list1);
        }
        return maps;
    }
}
