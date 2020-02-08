package br.com.technovaca.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.technovaca.model.Usuario;
import br.com.technovaca.service.UsuarioService;

@Service
public class UserDetailsCustom implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByUsename(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário e/ou senha inválidos");
		}
		return usuario;
	}
}
