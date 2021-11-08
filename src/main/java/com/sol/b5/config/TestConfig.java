package com.sol.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sol.b5.test.Child1;
import com.sol.b5.test.Child2;
import com.sol.b5.test.Test1;

@Configuration //XML 파일 역할, 객체를 정의하는 class를 의미
public class TestConfig {
	
	// 객체를 생성하는 메서드 선언
	@Bean // 객체를 생성, XML의 <bean> 태그 역할
	public Test1 getTest1() {
		Test1 test1 = new Test1();
		
		return test1;
	}
	
	@Bean("child1")
	public Child1 getChild1() {
		return new Child1();
	}
	
	@Bean("child2")
	public Child2 getChild2() {
		return new Child2();
	}
}
