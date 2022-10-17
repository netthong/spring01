package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;

//Spring4.0 부터 사용 가능
//@RestController는 뷰를 리턴하는 것이 아닌 json을 리턴
@RestController
public class SampleRestController {
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("세탁기", 1000000);
	}

}
