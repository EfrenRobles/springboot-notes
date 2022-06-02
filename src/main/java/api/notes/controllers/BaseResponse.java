package api.notes.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseResponse {
	
	protected ResponseEntity<?> onSuccess (Object result, HttpStatus status) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		response.put("data", result);

		return new ResponseEntity<>(response, status);
	}

	@SuppressWarnings("rawtypes")
	public Map onError (String result) {
		Map<String, String> response = new LinkedHashMap<>();
		response.put("status", "ERROR");
		response.put("error", result);

		return response;		
	}
}
