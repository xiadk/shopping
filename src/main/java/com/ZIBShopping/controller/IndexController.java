package com.ZIBShopping.controller;


import com.ZIBShopping.dao.StudentDao;
import com.ZIBShopping.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("he")
public class IndexController {

    @Autowired
    private StudentDao studentDao;

    @ResponseBody
    @RequestMapping("index")
    public Map<String,String> index(){

        System.out.println("s");
        List<Student> list = studentDao.findAll();
        Map<String,String> map = new HashMap<>();
        map.put("name","dk");
        return map;
    }

}
