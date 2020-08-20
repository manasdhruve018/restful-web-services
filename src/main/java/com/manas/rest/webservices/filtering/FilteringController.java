package com.manas.rest.webservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean getSomeBean(){
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> getListBean(){
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value11","value21","value31"));
	}
	
}
