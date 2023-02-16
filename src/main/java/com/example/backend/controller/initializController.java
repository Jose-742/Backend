package com.example.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.HelloDTO;
import com.example.backend.model.Hello;

@RestController
@RequestMapping("/api")
public class initializController {

	
	@GetMapping
	public ResponseEntity<?> mensagem(){
		HelloDTO helloDTO = new HelloDTO(new Hello().getNome());
		
			
		Map<String, String> nomes= new HashMap<String, String>();
		nomes.put("mensagem", helloDTO.getNome());
		return ResponseEntity.ok(nomes);
	}
	
}

