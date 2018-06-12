package org.norsys.pamela.webhookapi.model;

public class Vaccin {
	
	
	private Integer vaccinId;
	public Integer getVaccinId() {
		return vaccinId;
	}
	public void setVaccinId(Integer vaccinId) {
		this.vaccinId = vaccinId;
	}
	
	
	private String nomVaccin;
	public String getNomVaccin() {
		return nomVaccin;
	}
	public void setNomVaccin(String nomVaccin) {
		this.nomVaccin = nomVaccin;
	}
	
	
	private String typeVaccin;
	public String getTypeVaccin() {
		return typeVaccin;
	}
	public void setTypeVaccin(String typeVaccin) {
		this.typeVaccin = typeVaccin;
	}
	
	
	private String pays;
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	private boolean estObligatoire;
	public boolean isEstObligatoire() {
		return estObligatoire;
	}
	public void setEstObligatoire(boolean estObligatoire) {
		this.estObligatoire = estObligatoire;
	}
	
	
	

}
