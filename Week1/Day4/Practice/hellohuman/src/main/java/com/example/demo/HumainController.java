package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumainController {
	
	@RequestMapping("/")
	
	public String home(@RequestParam(value="name",required=false) String name,@RequestParam(value="lastname",required=false)String lastname ) { 
		if (name!=null) {
			String msg = String.format("Hello %s  %s ", name,lastname); 
			return msg;
		}
		else return "<h2>Hello Humain</>";
		
		
	}
}			  
	