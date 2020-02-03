package br.com.technovaca.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.technovaca.model.bovideo.Bovideo;

@Entity
public class Rebanho {
	
	@Id
	private String id;
	
	@OneToMany
	private List<Bovideo> animais;
	
	public Rebanho() {}
	
	public Rebanho(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Bovideo> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Bovideo> animais) {
		this.animais = animais;
	}
	
	
	
}
