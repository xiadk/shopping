package com.ZIBShopping.controller;

import com.ZIBShopping.common.Annotation.CurrentUser;
import com.ZIBShopping.common.Annotation.LoginRequired;
import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.ZIBShopping.service.PlaceOfReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zjh 2018.7.1
 */
@Controller
@RequestMapping("place")
public class PlaceOfReceiptController {
    @Autowired
    private PlaceOfReceiptService placeOfReceiptService;
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public PlaceOfReceiptDto addPlace(@RequestBody PlaceOfReceiptDto placeOfReceiptDto) {
        PlaceOfReceiptDto placeDto = placeOfReceiptService.findPlaceOfReceiptDtoById(placeOfReceiptDto.getId());
        placeDto.setIsDefault(placeOfReceiptDto.getIsDefault());
        PlaceOfReceiptDto place =  placeDto!=null ? placeOfReceiptService.save(placeDto):null;
        return place;
    }
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "savePlace",method = RequestMethod.POST)
    public PlaceOfReceiptDto savePlace(@RequestBody PlaceOfReceiptDto placeOfReceiptDto,@CurrentUser Long userId) {
        if(placeOfReceiptDto.getLinkMan()==null){

        }
        if(placeOfReceiptDto.getMobile()==null){

        }
        if(placeOfReceiptDto.getArea()==null){

        }
        if(placeOfReceiptDto.getCity()==null){

        }
        if(placeOfReceiptDto.getAddress()==null){

        }
        PlaceOfReceiptDto placeDto = null;
        if(placeOfReceiptDto.getId()<1){
            placeDto = new PlaceOfReceiptDto();
            placeDto.setUserId(userId);
        }else {
            placeDto = placeOfReceiptService.findPlaceOfReceiptDtoById(placeOfReceiptDto.getId());
        }
        placeDto.setLinkMan(placeOfReceiptDto.getLinkMan());
        placeDto.setMobile(placeOfReceiptDto.getMobile());
        placeDto.setAddress(placeOfReceiptDto.getAddress());
        placeDto.setArea(placeOfReceiptDto.getArea());
        placeDto.setCity(placeOfReceiptDto.getCity());
        placeDto.setCode(placeOfReceiptDto.getCode());
        placeDto.setCounties(placeOfReceiptDto.getCounties());
        PlaceOfReceiptDto place =  placeDto!=null ? placeOfReceiptService.save(placeDto):null;
        return place;
    }
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "findAllPlace",method = RequestMethod.POST)
    public List<PlaceOfReceiptDto> findPlaceOfReceiptDtos(@CurrentUser Long userId){
        List<PlaceOfReceiptDto> placeOfReceiptDtos = userId>-1 ? placeOfReceiptService.findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(userId):null;
        return placeOfReceiptDtos;
    }

    /**
     * 删除后返回list
     * @param id
     * @param userId
     * @return
     */
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "deletePlace",method = RequestMethod.GET)
    public List<PlaceOfReceiptDto> deletePlace(@RequestParam Long id,@CurrentUser Long userId){
        placeOfReceiptService.deletePlaceOfReceiptDtoById(id);
        List<PlaceOfReceiptDto> placeOfReceiptDtos = userId>-1 ? placeOfReceiptService.findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(userId):null;
        return placeOfReceiptDtos;
    }

    /**
     * 删除单个，返回code
     * @param id
     * @return
     */
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public Map<String,String> deleteSingle(@RequestParam Long id){
        placeOfReceiptService.deletePlaceOfReceiptDtoById(id);
        Map<String,String> map = new HashMap<>();
        map.put("code","1");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "findPlace",method = RequestMethod.GET)
    public PlaceOfReceiptDto findPlaceOfReceiptDto(@RequestParam Long id){
        PlaceOfReceiptDto placeOfReceiptDto = (id!=null) ? placeOfReceiptService.findPlaceOfReceiptDtoById(id):null;
        return placeOfReceiptDto;
    }

    /**
     * 默认地址

     * @return
     */
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "defaultPlace",method = RequestMethod.GET)
    public Map<String,Object> defaultPlace(@CurrentUser Long userId){

        return placeOfReceiptService.defaultPlace(userId,true);
    }
}
