package org.norsys.pamela.webhookapi.model;


public class Medecin {
	
	private Integer medecinID;
	public Integer getMedecinID() {
		return medecinID;
	}
	public void setMedecinID(Integer medecinID) {
		this.medecinID = medecinID;
	}
	
	
	private String nomMedecin;
	public String getNomMedecin() {
		return nomMedecin;
	}
	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	
	private String hopital;
	public String getHopital() {
		return hopital;
	}
	public void setHopital(String hopital) {
		this.hopital = hopital;
	}
	
	
	private String specialite;
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	
	private boolean disponibilite;
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	

}
