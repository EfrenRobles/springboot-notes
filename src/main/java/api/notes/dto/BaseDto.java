package api.notes.dto;

import java.util.HashMap;

public abstract class BaseDto {
	
	protected HashMap<String, Object> returnSuccess (Object result) {
		HashMap<String, Object> response = new HashMap<>();
		
		response.put("status", "SUCCESS");
		
		if (result == null) {
			result = new Object[0];
		}
		
		response.put("result", result);
		
		return response;
	}
}
