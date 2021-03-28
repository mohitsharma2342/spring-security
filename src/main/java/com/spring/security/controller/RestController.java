package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {
	
	
	@GetMapping
	public String rest() {
		return "You are authenticated";	
	}

}
