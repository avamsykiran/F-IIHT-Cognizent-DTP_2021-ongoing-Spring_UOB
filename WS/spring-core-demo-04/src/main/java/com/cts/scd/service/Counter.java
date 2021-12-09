package com.cts.scd.service;

import org.springframework.stereotype.Service;

@Service
public class Counter {

	private int count;
	
	public Counter() {}
	
	public int getCount() {
		count++;
		return count;
	}
}
