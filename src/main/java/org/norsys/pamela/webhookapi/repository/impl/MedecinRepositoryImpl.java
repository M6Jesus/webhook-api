package org.norsys.pamela.webhookapi.repository.impl;

import java.util.List;

import org.norsys.pamela.webhookapi.model.Medecin;
import org.norsys.pamela.webhookapi.repository.interfaces.MedecinRepository;

public class MedecinRepositoryImpl implements MedecinRepository {

	@Override
	public List<Medecin> tousLesMedecins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean estDisponible(String nomMedecin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String specialite(String nomMedecin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hopital(String nomMedecin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> nomParSpécialité(String specialite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> nomParHopital(String hopital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> nomParDisponibilite(Boolean disponibilité) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
