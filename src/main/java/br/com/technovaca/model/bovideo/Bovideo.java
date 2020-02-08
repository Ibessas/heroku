package br.com.technovaca.model.bovideo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.technovaca.model.Localizacao;
import br.com.technovaca.model.Rebanho;
import br.com.technovaca.model.Status;
import br.com.technovaca.model.Usuario;
import br.com.technovaca.model.Vacina;

@Entity
public abstract class Bovideo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private Calendar nascimento;
	@OneToOne
	private Bovideo progenitor;
	@OneToOne
	private Bovideo progenitora;
	private Status status;
	@JsonIgnore
	@ManyToOne
	private Rebanho rebanho;
	@OneToMany
	private List<Vacina> vacinas;
	@OneToMany
	private List<Bovideo> crias;
	@OneToOne
	private Localizacao localizacao;
	private Sexo sexo;
	
	private String foto;
	
	public Bovideo() {}
	
	public Bovideo(Rebanho rebanho, String nome, Calendar nascimento, Status status) {
		this.rebanho = rebanho;
		this.nome = nome;
		this.nascimento = nascimento;
		this.status = status;
	}
	
	public boolean isMyOwner(Usuario usuario) {
		return rebanho.isMyOwner(usuario);
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Bovideo getProgenitor() {
		return progenitor;
	}

	public void setProgenitor(Bovideo progenitor) {
		this.progenitor = progenitor;
	}

	public Bovideo getProgenitora() {
		return progenitora;
	}

	public void setProgenitora(Bovideo progenitora) {
		this.progenitora = progenitora;
	}

	public Rebanho getRebanho() {
		return rebanho;
	}

	public void setRebanho(Rebanho rebanho) {
		this.rebanho = rebanho;
	}

	public List<Bovideo> getCrias() {
		return crias;
	}

	public void setCrias(List<Bovideo> crias) {
		this.crias = crias;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
