package com.jayram.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayram.springbootconfig.util.DbSetting;

@RestController
public class GreetingController {

	@Autowired
	DbSetting dbSetting;
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("${app.description}")
	private String description;
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage+" "+description;
	}
	
	@GetMapping("/getDbSetting")
	public String getDbSetting() {
		return dbSetting.getConnection()+" "+dbSetting.getHost()+" "+dbSetting.getPort();
	}
}
