package com.cts.scd.service;

public class Counter {

	private int count;
	
	public Counter() {}
	
	public int getCount() {
		count++;
		return count;
	}
}
