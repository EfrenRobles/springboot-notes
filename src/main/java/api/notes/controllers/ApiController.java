package api.notes.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiController extends BaseResponse {

	@GetMapping
	public ResponseEntity<?> hello() {
		return onSuccess(TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis()), HttpStatus.OK);
	}

	@GetMapping("healthCheck")
	public ResponseEntity<?> healthCheck() {

		Map<String, String> data = new LinkedHashMap<>();
		data.put("title", "Service is working");
		data.put("message", "EVERYTHING-IS-FINE");
		
		return onSuccess(data, HttpStatus.OK);
	}
}
