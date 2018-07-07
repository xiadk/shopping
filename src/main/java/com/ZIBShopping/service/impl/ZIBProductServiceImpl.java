package com.ZIBShopping.service.impl;

import com.ZIBShopping.dao.ZIBProductDao;
import com.ZIBShopping.dto.ZIBProductDto;
import com.ZIBShopping.service.ZIBProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * zjh 2018.7.2
 */
@Service
public class ZIBProductServiceImpl implements ZIBProductService {
    @Autowired
    private ZIBProductDao zibProductDao;
    @Override
    public List<ZIBProductDto> findPage(@NotNull String updateTime,@NotNull Long row) {
        return zibProductDao.findZIBProductDtos(updateTime,row);
    }

    @Override
    public ZIBProductDto recommendProduct(Long count) {
        return zibProductDao.findZIBProductDto(count);
    }
}
