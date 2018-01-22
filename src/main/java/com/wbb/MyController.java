package com.wbb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wbb.interceptor.AccessControl;

@RestController
public class MyController {
	
	@AccessControl(requireCheck=true)
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		return "Hello spring security oauth2";
	}
	
}
