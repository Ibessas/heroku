package br.com.technovaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.technovaca.model.Rebanho;

public interface RebanhoRepository extends JpaRepository<Rebanho, String>{
	Rebanho getRebanhoById(int id);
}
