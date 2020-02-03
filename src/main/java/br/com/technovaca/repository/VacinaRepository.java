package br.com.technovaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.technovaca.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, String>{

	Vacina getVacinaById(int id);
}
