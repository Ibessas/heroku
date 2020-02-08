package br.com.technovaca.model.bovideo;

import java.util.Calendar;

import javax.persistence.Entity;

import br.com.technovaca.model.Rebanho;
import br.com.technovaca.model.Status;

@Entity
public class Femea extends Bovideo{	
	
	public Femea() {}
	
	public Femea(Rebanho rebanho,String id, Calendar nascimento, Status status) {
		super(rebanho, id, nascimento, status);
	}	
}
