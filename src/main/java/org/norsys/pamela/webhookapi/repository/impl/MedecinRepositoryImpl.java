package org.norsys.pamela.webhookapi.repository.impl;

import java.util.List;

import org.norsys.pamela.webhookapi.repository.interfaces.MedecinRepository;
import org.norsys.pamela.webhookapi.repository.rowmappers.NomMedecinRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MedecinRepositoryImpl implements MedecinRepository {

	@Autowired
	public JdbcTemplate jt;

	@Override
	public List<String> tousLesMedecins() {
		String TOUS_LES_MEDECINS = "select nomMedecin from medecin";
		
		RowMapper<String> vRowMapper = new NomMedecinRM();
		return jt.query(TOUS_LES_MEDECINS, vRowMapper);
	}

	@Override
	public Boolean estDisponible(String nomMedecin) {
		String EST_IL_DISPO = "SELECT disponibilite FROM medecin WHERE nomMedecin = ?";
		Object[] inputs = new Object[] {nomMedecin};

		return jt.queryForObject(EST_IL_DISPO, inputs, Boolean.class);
	}

	@Override
	public String specialite(String nomMedecin) {
		String SPECIALITE = "SELECT specialite FROM medecin WHERE nomMedecin = ?";
		Object[] inputs = new Object[] {nomMedecin};
		
		return jt.queryForObject(SPECIALITE, inputs, String.class);
	}
	
	@Override
	public String hopital(String nomMedecin) {
		String HOPITAL = "SELECT hopital FROM medecin WHERE nomMedecin = ?";
		Object[] inputs = new Object[] {nomMedecin};
		return jt.queryForObject(HOPITAL, inputs,  String.class);
	}

	@Override
	public List<String> nomParSpecialite(String specialite) {
		String NOM_PAR_SPECIALITE = "SELECT nomMedecin FROM medecin WHERE specialite = ?";
		Object[] inputs = new Object[] {specialite};
		RowMapper<String> vRowMapper = new NomMedecinRM();
		return jt.query(NOM_PAR_SPECIALITE, inputs, vRowMapper);
	}

	@Override
	public List<String> nomParHopital(String hopital) {
		String NOM_PAR_HOPITAL = "SELECT nomMedecin FROM medecin WHERE hopital = ?";
		Object[] inputs = new Object[] {hopital};
		RowMapper<String> vRowMapper = new NomMedecinRM();
		return jt.query(NOM_PAR_HOPITAL, inputs, vRowMapper);
	}

	@Override
	public List<String> nomParDisponibilite() {
		String EST_DISPO = "SELECT nomMedecin FROM medecin WHERE disponibilite = TRUE";
		RowMapper<String> vRowMapper = new NomMedecinRM();
		return jt.query(EST_DISPO, vRowMapper);
	}

}
