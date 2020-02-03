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

import br.com.technovaca.model.bovideo.Bovideo;
import br.com.technovaca.model.bovideo.Femea;
import br.com.technovaca.model.bovideo.Macho;
import br.com.technovaca.model.bovideo.Sexo;
import br.com.technovaca.service.BovideoService;

@RestController
@RequestMapping("bovideo")
public class BovideoController {
	
	@Autowired
	private BovideoService service;
	
	@GetMapping("")
	public ResponseEntity<List<Bovideo>> getAllBovideo(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bovideo> getBovideoById(@PathVariable int id){
		return ResponseEntity.ok(service.getBovideoById(id));
	}
	
	@PostMapping("/macho")
	public ResponseEntity<Bovideo> postBovideoMacho(@RequestBody Macho id){
		id.setSexo(Sexo.MACHO);
		return ResponseEntity.ok(service.postBovideo(id));
	}
	
	@PostMapping("/femea")
	public ResponseEntity<Bovideo> postBovideoFemea(@RequestBody Femea id){
		id.setSexo(Sexo.FEMEA); 
		return ResponseEntity.ok(service.postBovideo(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Bovideo> putBovideo(@PathVariable("id")String original, @RequestBody Bovideo atualizado){
		atualizado.setId(original);
		return ResponseEntity.ok(service.putBovideo(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void deleteBovideo(@PathVariable int id){
		service.delete(service.getBovideoById(id));
	}
	
}
