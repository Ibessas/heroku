package br.com.technovaca.model.bovideo;

import java.util.Calendar;

import javax.persistence.Entity;

import br.com.technovaca.model.Rebanho;
import br.com.technovaca.model.Status;

@Entity
public class Macho extends Bovideo{

	public Macho(Rebanho rebanho, String id, Calendar nascimento, Status status) {
		super(rebanho, id, nascimento, status);
	}
	
	public Macho() {
		
	}

}
