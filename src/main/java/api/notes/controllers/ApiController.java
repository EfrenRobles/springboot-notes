package api.notes.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.notes.models.Users;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

	@GetMapping
	public long hello() {
		return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
	}

	@GetMapping("healthCheck")
	public ResponseEntity<Object> healthCheck() {

		Map<String, String> data = new HashMap<>();
		data.put("id", "EVERYTHING-IS-FINE");
		data.put("title", "Service is working");

		Map<String, Object> response = new HashMap<>();
		response.put("status", "SUCCESS");
		response.put("data", data);

		return ResponseEntity.ok(response);
	}
}
