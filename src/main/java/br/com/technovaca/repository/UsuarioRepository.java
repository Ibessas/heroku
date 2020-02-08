package br.com.technovaca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.technovaca.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Usuario getUsuarioById(int id);

	Usuario findByNome(String Nome);

	Usuario getUsuarioByNome(String username);
	
}
