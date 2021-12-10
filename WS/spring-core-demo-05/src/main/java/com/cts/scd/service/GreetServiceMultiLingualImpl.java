package com.cts.scd.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultiLingualImpl implements GreetService {

	//@Value("${greet.greetings}")
	//private String[] greetings;
	
	//@Value("#{${greet.greetings.list}}")
	//private List<String> greetings;

	@Value("#{${greet.greetings.map}}")
	private Map<String,String> greetings;
	
	@Override
	public String greet(String userName) {
		
		StringBuffer sb = new StringBuffer();
		/*for(String greeting:greetings)
			sb.append(String.format("%s! %s!\n", greeting, userName));
		*/
		
		for(String key:greetings.keySet())
			sb.append(String.format("%s\t %s! %s!\n", key,greetings.get(key), userName));
		
		return sb.toString();
	}
}
