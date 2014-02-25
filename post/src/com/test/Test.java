package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		String url = "http://localhost:8081/platform/user/send";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("param1", "test1");
		params.put("param2", "200");
		
		// this is a test
		String result = HttpUtil.http(url, params);
		
		System.out.println(result);
	}
}
