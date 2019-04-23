package com.teahyuk.webservice.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebRestController {

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
}