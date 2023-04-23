package com.springboot.hello.api.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hello.api.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	
	// /api/v1/post-api/domain
	@RequestMapping(value = "/domain", method = RequestMethod.POST)
	public String postExample() {
		return "Hello Post API";
	}
	
	// /api/v1/post-api/member?name=value1&email=value2&org=value3
	@PostMapping(value = "/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuffer sb = new StringBuffer();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	/* 
	 * member1과 member2는 어떤 차이가 있는가????
	 * member1은 HEADERS 항목의 content-type을 보면 text/plain으로서 결괏값으로 일반 문자열이
	 * 전달됐음을 확인할 수 있음
	 * 반면 member2의 content-type은 application/json임 
	 */
	
	// /api/v1/post-api/member1?name=value1&email=value2&org=value3
	@PostMapping(value = "/member1")
	public String postMemberDto1(@RequestBody MemberDto memberDto) {
		return memberDto.toString();
	}
	
	// /api/v1/post-api/member2?name=value1&email=value2&org=value3
	@PostMapping(value = "/member2")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
		return memberDto;
	}
	
	/* 
	 * 스프링 프레임워크에는 HttpEntity라는 클래스가 있습니다. HttpEntity는 다음과 같이 헤더(Header)와
	 * Body로 구성된 Http 요청과 응답을 구성하는 역할을 가지고 있습니다.
	 * RequestEntity와 ResponseEntity는 HttpEntity를 상속받아 구현한 클래스입니다. 그중 Response
	 * Entity는 서버에 들어온 요청에 대해 응답 데이터를 구성해서 전달할 수 있게 합니다. 다음과 같이 Response
	 * Entity는 HttpEntity로 부터 HttpHeaders와 Body를 가지고 자체적으로 HttpStatus를 구현 
	 */
	
	// /api/v1/post-api/member3?name=value1&email=value2&org=value3
	@PutMapping(value = "/member3")
	public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED) // status(HttpStatus.ACCEPTED)은 응답코드 202를 가지고 있음
				.body(memberDto);
	}
	
}
