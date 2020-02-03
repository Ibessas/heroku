package br.com.technovaca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int tempoVencimentoDias;
	private String nome;
	private String descricao;
	
	public Vacina() {}
	
	public Vacina(int tempoVencimentoDias, String nome, String descricao) {
		super();
		this.tempoVencimentoDias = tempoVencimentoDias;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempoVencimentoDias() {
		return tempoVencimentoDias;
	}

	public void setTempoVencimentoDias(int tempoVencimentoDias) {
		this.tempoVencimentoDias = tempoVencimentoDias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
