package br.com.technovaca.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.technovaca.model.bovideo.Bovideo;


@Entity
public class Rebanho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	private Usuario usuario;
	
	public Rebanho() {}
	
	@OneToMany(mappedBy="rebanho", cascade = CascadeType.REMOVE)
	private List<Bovideo> animais;
	
	public Rebanho(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Bovideo> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Bovideo> animais) {
		this.animais = animais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isMyOwner(Usuario usuario) {
		return usuario.getId() == this.usuario.getId();
	}
	
	
	
}
