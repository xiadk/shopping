package com.dk.zb.controller;


import com.dk.zb.dto.Student;
import com.dk.zb.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("he")
public class IndexController {

    @Autowired
    private StudentDao studentDao;

    @ResponseBody
    @RequestMapping("index")
    public Object index(){

        System.out.println("s");
        List<Student> list = studentDao.findAll();

        return "lss";
    }

}
