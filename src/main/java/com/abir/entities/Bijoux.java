package com.abir.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bijoux implements Serializable {

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int ID_Bijoux;
	private String NOM_Bijoux;
	private int Prix;

	public int getId() {
		return ID_Bijoux;
	}

	public void stId(int ID_Bijoux) {
		this.ID_Bijoux = ID_Bijoux;
	}

	public String getNom() {
		return NOM_Bijoux;
	}

	public void setNom(String nom) {
		this.NOM_Bijoux = nom;
	}

	public int get() {
		return Prix;
	}

	public void set(int Prix) {
		this.Prix = Prix;
	}
}