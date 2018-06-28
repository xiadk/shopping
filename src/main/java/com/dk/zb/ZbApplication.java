package com.dk.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
//@SpringBootApplication 
public class ZbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZbApplication.class, args);
	}

	@RequestMapping("/index")
	public static String test(){

	    return "hello world";
    }
}
