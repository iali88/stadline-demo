package com.stadline.demo.entity;

public class SimpleEvent {

	private String date;

	private String heureDeb;

	private long duree;

	private String nomSalle;

	private String nomActivite;

	private int nbPlace;

	public SimpleEvent(String date, String heureDeb, long duree, String nomSalle, String nomActivite, int nbPlace) {
		this.date = date;
		this.heureDeb = heureDeb;
		this.duree = duree;
		this.nomSalle = nomSalle;
		this.nomActivite = nomActivite;
		this.nbPlace = nbPlace;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public long getDuree() {
		return duree;
	}

	public void setDuree(long duree) {
		this.duree = duree;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public String getNomActivite() {
		return nomActivite;
	}

	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	

}
