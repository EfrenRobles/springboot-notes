package com.example.demo.repositories;

import java.util.HashMap;

public abstract class BaseReposiroty {
	
	protected HashMap<String, Object> returnSuccess (Object result) {
		HashMap<String, Object> response = new HashMap<>();
		response.put("status", "SUCCESS");
		response.put("result", result);
		
		return response;
	}
}
