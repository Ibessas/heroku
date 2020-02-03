package br.com.technovaca.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localizacao {
	
	@Id
	private int id;
	private int longitude;
	private int latitude;
	
	public Localizacao() {}
	
	public Localizacao(int longitude, int latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	
}
