package br.com.technovaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.technovaca.model.Usuario;
import br.com.technovaca.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
	
	public List<Usuario> getAll() {
		return repository.findAll();	
	}
	
	public Usuario postUsuario(Usuario u) {
		Usuario novo = new Usuario(
				u.getUsername(), u.getEmail(), u.getTelefone(), bcryptEncoder.encode(u.getPassword()));
		return repository.save(novo);
	}

	public List<Usuario> postListOfUsuario(List<Usuario> usuarios) {
		for(Usuario u : usuarios)
			repository.save(u);
		return usuarios;
	}

	public Usuario getUsuarioById(int id) {
		return repository.getUsuarioById(id);
	}

	public Usuario putUsuario(Usuario atualizado) {
		return repository.save(atualizado);
	}

	public void delete(Usuario id) {
		repository.delete(id);
	}

	public Usuario findByUsename(String username) {
		return repository.getUsuarioByNome(username);
	}

}
