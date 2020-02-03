package br.com.technovaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.technovaca.model.Rebanho;
import br.com.technovaca.model.Usuario;
import br.com.technovaca.security.JwtRequest;
import br.com.technovaca.security.JwtTokenUtil;
import br.com.technovaca.service.RebanhoService;
import br.com.technovaca.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private RebanhoService rebanhoService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<String> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<Usuario>> getAllUsuario(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id){
		return ResponseEntity.ok(service.getUsuarioById(id));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.ok(service.postUsuario(usuario));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> putUsuario(@PathVariable("id")int original, @RequestBody Usuario atualizado){
		atualizado.setId(original);
		return ResponseEntity.ok(service.putUsuario(atualizado));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable int id){
		service.delete(service.getUsuarioById(id));
	}
	
	@PutMapping("/{usuario}")
	public void addRebanho(@PathVariable int usuario, @RequestBody Rebanho rebanho) {
		rebanhoService.postRebanho(rebanho);
	}
}
