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
import br.com.technovaca.service.RebanhoService;
import javassist.NotFoundException;

@RestController
@RequestMapping("rebanho")
public class RebanhoController {
	
	@Autowired
	private RebanhoService service;
	
	@GetMapping("")
	public ResponseEntity<List<Rebanho>> getAllRebanho(@AuthenticationPrincipal Usuario usuario){
		return ResponseEntity.ok(service.findByUsuarioId(usuario.getId()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rebanho> getRebanhoById(@AuthenticationPrincipal Usuario usuario, @PathVariable int id)
			throws NotFoundException{
		
		if(null == service.getRebanhoById(id))
			throw new NotFoundException("Rebanho not found");

		Rebanho rebanho = service.getRebanhoById(id);
		
		
		if(!rebanho.isMyOwner(usuario))
			throw new NotAllowedException();

		return ResponseEntity.ok(rebanho);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Rebanho> postRebanho(@AuthenticationPrincipal Usuario usuario, @RequestBody Rebanho rebanho){
		rebanho.setUsuario(usuario);
		return ResponseEntity.ok(service.postRebanho(rebanho));
	}
	
	
	@PutMapping("/{original}")
	public ResponseEntity<Rebanho> putRebanho(@AuthenticationPrincipal Usuario usuario, @PathVariable("original")Rebanho original, @RequestBody Rebanho atualizado){
		if(!original.isMyOwner(usuario))
			throw new NotAllowedException();
		atualizado.setId(original.getId());
		atualizado.setUsuario(usuario);
		atualizado.setAnimais(original.getAnimais());
		return ResponseEntity.ok(service.putRebanho(atualizado));
	}
	 
	@DeleteMapping("/{rebanho}")
	public void deleteRebanho(@AuthenticationPrincipal Usuario usuario, @PathVariable Rebanho rebanho){
		if(!rebanho.isMyOwner(usuario))
			throw new NotAllowedException();
		
		service.delete(service.getRebanhoById(rebanho.getId()));
	}
}
