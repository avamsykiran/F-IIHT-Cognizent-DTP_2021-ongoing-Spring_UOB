package com.cts.scbd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Counter {

	@Value("${counter.initCount}")
	private int count;
	
	public Counter() {}
	
	public int getCount() {
		count++;
		return count;
	}
}
