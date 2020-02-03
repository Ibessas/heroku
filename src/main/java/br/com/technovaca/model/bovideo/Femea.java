package br.com.technovaca.model.bovideo;

import java.util.Calendar;

import javax.persistence.Entity;

import br.com.technovaca.model.Status;

@Entity
public class Femea extends Bovideo{	
	
	public Femea() {}
	
	public Femea(String id, Calendar nascimento, Status status) {
		super(id, nascimento, status);
	}	
}
