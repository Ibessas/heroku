package br.com.technovaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.technovaca.model.Vacina;
import br.com.technovaca.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository repository;
	
	public List<Vacina> getAll() {
		return repository.findAll();	
	}
	
	public Vacina postVacina(Vacina u) {
		return repository.save(u);
	}

	public List<Vacina> postListOfVacina(List<Vacina> Vacinas) {
		for(Vacina u : Vacinas)
			repository.save(u);
		return Vacinas;
	}

	public Vacina getVacinaById(int id) {
		return repository.getVacinaById(id);
	}

	public Vacina putVacina(Vacina atualizado) {
		return repository.save(atualizado);
	}

	public void delete(Vacina id) {
		repository.delete(id);
	}
}
