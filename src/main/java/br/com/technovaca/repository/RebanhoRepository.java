package br.com.technovaca.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.technovaca.model.Rebanho;

public interface RebanhoRepository extends JpaRepository<Rebanho, String>{
	Rebanho getRebanhoById(int id);

	List<Rebanho> getByUsuarioId(int usuario);
}
