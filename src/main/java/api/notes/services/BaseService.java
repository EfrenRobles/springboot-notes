package api.notes.services;

import java.util.LinkedHashMap;

public abstract class BaseService {
	
	protected LinkedHashMap<String, Object> returnSuccess (Object result) {
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		
		response.put("status", "SUCCESS");
		
		if (result == null) {
			result = new Object[0];
		}
		
		response.put("result", result);
		
		return response;
	}
}
