package br.com.technovaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.technovaca.model.bovideo.Bovideo;
import br.com.technovaca.repository.BovideoRepository;

@Service
public class BovideoService {

	@Autowired
	private BovideoRepository repository;
	
	public List<Bovideo> getAll() {
		return repository.findAll();	
	}
	
	public Bovideo postBovideo(Bovideo u) {
		return repository.save(u);
	}

	public List<Bovideo> postListOfBovideo(List<Bovideo> Bovideos) {
		for(Bovideo u : Bovideos)
			repository.save(u);
		return Bovideos;
	}

	public Bovideo getBovideoById(int id) {
		return repository.getBovideoById(id);
	}

	public Bovideo putBovideo(Bovideo atualizado) {
		return repository.save(atualizado);
	}

	public void delete(Bovideo id) {
		repository.delete(id);
	}

	public List<Bovideo> getByRebanho(int id) {
		return repository.getByRebanhoId(id);
	}
	
}
