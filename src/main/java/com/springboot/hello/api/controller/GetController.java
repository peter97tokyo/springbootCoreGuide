package com.springboot.hello.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hello.api.dto.MemberDto;

/* 공통으로 사용하는 URL
 * @RequestMapping 어노테이을 별다른 설정 없이 선언하면 HTTP의 모든 요청을 받습니다.
 */
@RestController
@RequestMapping("/api/v1/get-api") 
public class GetController {
	
	// GET API는 웹 애플리케이션 서버에서 값을 가져올 때 사용하는 api입니다.
	// URL /api/v1/get-api/hello
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello() {
		return "Hello World";
	}
	/* 
	 * Whitelabel Error Page - 239416
	 * 원인 - *Application.java 가 있는 패키지 하위에 구성해야 맵핑이 됩니다.
	 * 404 error와 비슷한 느낌같다.
	 */ 
	// URL /api/v1/get-api/name
	@GetMapping(value = "/name")
	public String getName() {
		return "peter";
	}
	/*
	 * @PathVariable을 활용한 GET 메서드 구현
	 * 값을 간단하게 전달할 때 사용하며 GET 요청에서 보통 사용됩니다
	 * URL /api/v1/get-api/variable/{variable}
	 */
	@GetMapping(value = "/variable/{variable}")
	public String getVariable1(@PathVariable String variable) {
		/* 
		 * 어노테이션에 지정한 변수의 이름과 메서드 매개변수의 이름을 동일하게 맞추기 어렵다면 @PathVariable 뒤에 괄호를 열어
		 * GetMapping 어노테이션의 변수명을 지정합니다.
		 * ex 
		 * @GetMapping(value = "/variable/{variable}")
		 * @PathVariable("variable") String variable
		 */ 
		return variable;
	}
	/*
	 * @RequestParam을 활용한 GET 메서드 구현 
	 * 어노테이션을 활용하여 쿼리를 변수와 맵핑합니다.
	 * URL /api/v1/get-api/request1?name=value1&email=value2&org=value3
	 */
	@GetMapping(value = "/request1")
	public String getRequestParam(@RequestParam String name, 
								  @RequestParam String email, 
								  @RequestParam String org) {
		return name + " " + email + " " + org;
	}
	/*
	 * @RequestParam을 활용한 GET 메서드 구현 2 
	 * 쿼리의 key가 많거나 무엇이 들어올지 모르는 경우
	 * URL /api/v1/get-api/request2?key1=value1&key2=value2&key3=value3
	 */
	@GetMapping(value = "/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuffer sb = new StringBuffer();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	/* 
	 * 쿼리스트링의 키가 정해져 있지만 받아야할 파라미터가 많을 경우 아래 처럼 활용하여 가독성을 높일 수 있음 
	 * URL /api/v1/get-api/request3?name=value1&email=value2&org=value3
	 */
	@GetMapping(value = "/request3")
	public String getRequestParam3(MemberDto memberDto) {
		return memberDto.toString();
	}
	
}
