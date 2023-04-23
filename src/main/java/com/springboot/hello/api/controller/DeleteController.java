package com.springboot.hello.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	
	/*
	 * Delete API는 웹 애플리케이션 서버를 거쳐 데이터 베이스 등의 저장소에 있는 리소스를 삭제할 때 사용합니다.
	 * /api/v1/delete-api/{variable}
	 */
	@DeleteMapping(value = "/{variable}")
	public String DeleteVariable(@PathVariable String variable) {
		return variable;
	}
	// /api/v1/delete-api/request1?email=value1
	@DeleteMapping(value = "/request1")
	public String getRequestParam(@RequestParam String email) {
		return email;
	}
}
