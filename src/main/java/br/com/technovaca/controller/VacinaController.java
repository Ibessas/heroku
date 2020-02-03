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

import br.com.technovaca.model.Vacina;
import br.com.technovaca.service.VacinaService;

@RestController
@RequestMapping("vacina")
public class VacinaController {
	
	@Autowired
	private VacinaService service;

	@GetMapping("")
	public ResponseEntity<List<Vacina>> getAllVacina(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vacina> getVacinaById(@PathVariable int id){
		return ResponseEntity.ok(service.getVacinaById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Vacina> postVacina(@RequestBody Vacina id){
		return ResponseEntity.ok(service.postVacina(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vacina> putVacina(@PathVariable("id")int original, @RequestBody Vacina atualizado){
		atualizado.setId(original);
		return ResponseEntity.ok(service.putVacina(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void deleteVacina(@PathVariable Vacina id){
		service.delete(id);
	}
}
