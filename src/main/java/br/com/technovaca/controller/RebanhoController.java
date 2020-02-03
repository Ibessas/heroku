package br.com.technovaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.technovaca.model.Rebanho;
import br.com.technovaca.service.RebanhoService;

@RestController
@RequestMapping("rebanho")
public class RebanhoController {
	
	@Autowired
	private RebanhoService service;
	
	@GetMapping("")
	public ResponseEntity<List<Rebanho>> getAllRebanho(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rebanho> getRebanhoById(@PathVariable int id){
		return ResponseEntity.ok(service.getRebanhoById(id));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Rebanho> postRebanho(@RequestBody Rebanho id){
		return ResponseEntity.ok(service.postRebanho(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Rebanho> putRebanho(@PathVariable("id")String original, @RequestBody Rebanho atualizado){
		atualizado.setId(original);
		return ResponseEntity.ok(service.putRebanho(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void deleteRebanho(@PathVariable int id){
		service.delete(service.getRebanhoById(id));
	}
}
