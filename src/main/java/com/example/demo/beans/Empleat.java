package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="treballadors")
public class Empleat {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@Column(name="feina")
	@Enumerated(EnumType.STRING)
	private Feina feina;
	private int sou;
	
	public Empleat (int id, String nom, Feina feina) {
		this.id = id;
		this.nom = nom;
		this.feina = feina;
		this.setSou(feina);
	}
	
	public Empleat() {
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Feina getFeina() {
		return feina;
	}

	public void setFeina(Feina feina) {
		this.feina = feina;
	}
	
	public void setSou(Feina feina) {
		switch(feina) {
		case ADMINISTRACIO: 
			this.sou = 1200;
			break;
		case CEO: 
			this.sou = 3000;
			break;
		case CTO: 
			this.sou = 2500;
			break;
		case CMO: 
			this.sou = 2300;
			break;
		case TECNIC: 
			this.sou = 1500;
			break;
		case BECARI: 
			this.sou = 900;
			break;
		}

	}
	
	public int getSou() {
		return sou;
	}

}
