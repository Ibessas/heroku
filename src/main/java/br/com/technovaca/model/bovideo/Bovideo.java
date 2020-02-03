package br.com.technovaca.model.bovideo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.technovaca.model.Localizacao;
import br.com.technovaca.model.Rebanho;
import br.com.technovaca.model.Status;
import br.com.technovaca.model.Vacina;

@Entity
public abstract class Bovideo {
	
	@Id
	private String id;
	
	private Calendar nascimento;
	@OneToOne
	private Bovideo progenitor;
	@OneToOne
	private Bovideo progenitora;
	private Status status;
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
	
	public Bovideo(String id, Calendar nascimento, Status status) {
		this.id = id;
		this.nascimento = nascimento;
		this.status = status;
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
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getDataNasc() {
		return nascimento;
	}

	public void setDataNasc(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
