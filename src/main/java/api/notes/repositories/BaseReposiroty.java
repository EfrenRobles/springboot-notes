package api.notes.repositories;

import java.util.HashMap;

public abstract class BaseReposiroty {
	
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
