package com.springboot.hello.api.dto;
/*
 * DTO Data Transfer Object 
 * 다른 레이어 간의 데이터 교환에 활용됩니다. 간략하게 설명하자면 각 클래스 및 인터페이스를 호출하면서
 * 전달하는 매개변수로 사용되는 데이터 객체입니다. Dto에는 별도에 로직이 포함되지 않습니다. 
 */
public class MemberDto {
	private String name;
	private String email;
	private String org;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	
	@Override
	public String toString() {
		
		return "MemberDto{" +
		"name= '" + name +"\'" + 
		", email='" + email + "\'" +
		", org='" + org + "\'" + "}";
	}
}
