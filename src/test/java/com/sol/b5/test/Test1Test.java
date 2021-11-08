package com.sol.b5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test1Test {
	
	@Autowired
	private Test1 test1;
	
	/*
	 * @Autowired private Child1 ch1;
	 * 
	 * @Autowired private Child2 ch2;
	 */
	
	@Autowired
	private Parent child1;
	
	@Test
	void test() {
		System.out.println(child1 != null);
		//System.out.println(ch1 != null);
		//System.out.println(ch2 != null);
		assertNotNull(test1);
	}

}
