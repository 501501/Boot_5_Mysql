package com.sol.b5.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void takeBus() {
		System.out.println("Bus ---");
	}
	
	public void takeSubway() {
		System.out.println("Subway ---");
	}
}
