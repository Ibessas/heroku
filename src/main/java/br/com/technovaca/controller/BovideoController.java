package br.com.technovaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.technovaca.error.NotAllowedException;
import br.com.technovaca.model.Rebanho;
import br.com.technovaca.model.Usuario;
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
	public ResponseEntity<Bovideo> getBovideoById(@AuthenticationPrincipal Usuario usuario, @PathVariable Bovideo id){
		if(!id.isMyOwner(usuario))
			throw new NotAllowedException();
		return ResponseEntity.ok(service.getBovideoById(id.getId()));
	}
	
	@PostMapping("/macho/{rebanho}")
	public ResponseEntity<Bovideo> postBovideoMacho(@AuthenticationPrincipal Usuario usuario, @PathVariable Rebanho rebanho, @RequestBody Macho id){
		if(!rebanho.isMyOwner(usuario))
			throw new NotAllowedException();
		id.setSexo(Sexo.MACHO);
		id.setRebanho(rebanho);
		return ResponseEntity.ok(service.postBovideo(id));
	}
	
	@PostMapping("/femea/{rebanho}")
	public ResponseEntity<Bovideo> postBovideoFemea(@AuthenticationPrincipal Usuario usuario, @PathVariable Rebanho rebanho, @RequestBody Femea id){
		if(!rebanho.isMyOwner(usuario))
			throw new NotAllowedException();
		id.setSexo(Sexo.FEMEA); 
		id.setRebanho(rebanho);
		return ResponseEntity.ok(service.postBovideo(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Bovideo> putBovideo(@AuthenticationPrincipal Usuario usuario, @PathVariable("id")Bovideo original, @RequestBody Bovideo atualizado){
		if(!original.isMyOwner(usuario))
			throw new NotAllowedException();
		atualizado.setId(original.getId());
		return ResponseEntity.ok(service.putBovideo(atualizado));
	}
	
	@GetMapping("/rebanho/{id}")
	public ResponseEntity<List<Bovideo>> getByRebanho(@PathVariable("id") Rebanho id, @AuthenticationPrincipal Usuario usuario){
		if(!id.isMyOwner(usuario))
			throw new NotAllowedException();
		return ResponseEntity.ok(service.getByRebanho(id.getId()));
	}
	
	@DeleteMapping("/{id}")
	public void deleteBovideo(@AuthenticationPrincipal Usuario usuario, @PathVariable Bovideo id){
		if(!id.isMyOwner(usuario))
			throw new NotAllowedException();
		service.delete(service.getBovideoById(id.getId()));
	}
	
}
