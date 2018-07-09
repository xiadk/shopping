package com.ZIBShopping.controller;

import com.ZIBShopping.common.Annotation.CurrentUser;
import com.ZIBShopping.common.Annotation.LoginRequired;
import com.ZIBShopping.dto.PlaceOfReceiptDto;
import com.ZIBShopping.service.PlaceOfReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        PlaceOfReceiptDto placeDto = placeOfReceiptService.findPlaceOfReceiptDtoById(placeOfReceiptDto.getId());
        placeDto.setIsDefault(placeOfReceiptDto.getIsDefault());
        PlaceOfReceiptDto place =  placeDto!=null ? placeOfReceiptService.save(placeDto):null;
        if(place==null){

        }
        return place;
    }
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "findAllPlace",method = RequestMethod.POST)
    public List<PlaceOfReceiptDto> findPlaceOfReceiptDtos(@CurrentUser Long userId){
        List<PlaceOfReceiptDto> placeOfReceiptDtos = userId>-1 ? placeOfReceiptService.findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(userId):null;
        return placeOfReceiptDtos;
    }
    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "deletePlace",method = RequestMethod.GET)
    public List<PlaceOfReceiptDto> deletePlace(@RequestParam Long id,@CurrentUser Long userId){
        placeOfReceiptService.deletePlaceOfReceiptDtoById(id);
        List<PlaceOfReceiptDto> placeOfReceiptDtos = userId>-1 ? placeOfReceiptService.findPlaceOfReceiptDtosByUserIdOrderByUpdateTimeDesc(userId):null;
        return placeOfReceiptDtos;
    }

    @ResponseBody
    @RequestMapping(value = "findPlace",method = RequestMethod.GET)
    public PlaceOfReceiptDto findPlaceOfReceiptDto(@RequestParam Long id){
        PlaceOfReceiptDto placeOfReceiptDto = (id!=null) ? placeOfReceiptService.findPlaceOfReceiptDtoById(id):null;
        return placeOfReceiptDto;
    }
}
