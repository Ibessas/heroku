package br.com.technovaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.technovaca.model.Rebanho;
import br.com.technovaca.repository.RebanhoRepository;

@Service
public class RebanhoService {

	@Autowired
	private RebanhoRepository repository;
	
	public List<Rebanho> getAll() {
		return repository.findAll();	
	}
	
	//TODO atualizar lista de rebanhos no usuário ao adicionar rebanho
	public Rebanho postRebanho(Rebanho u) {
		return repository.save(u);
	}

	public List<Rebanho> postListOfRebanho(List<Rebanho> Rebanhos) {
		for(Rebanho u : Rebanhos)
			repository.save(u);
		return Rebanhos;
	}

	public Rebanho getRebanhoById(int id) {
		return repository.getRebanhoById(id);
	}

	public Rebanho putRebanho(Rebanho atualizado) {
		return repository.save(atualizado);
	}

	public void delete(Rebanho id) {
		repository.delete(id);
	}

	public List<Rebanho> findByUsuarioId(int usuario) {
		return repository.getByUsuarioId(usuario);
	}
	
}
