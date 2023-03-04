package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class initializController {

	
	@GetMapping
	public ResponseEntity<?> mensagem(){
//		HelloDTO helloDTO = new HelloDTO(new Hello().getNome());
//		
//			
//		Map<String, String> nomes= new HashMap<String, String>();
//		nomes.put("mensagem", helloDTO.getNome());
		
		
		return ResponseEntity.ok().build();
	}
	
}

