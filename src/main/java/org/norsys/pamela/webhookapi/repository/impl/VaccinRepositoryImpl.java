package org.norsys.pamela.webhookapi.repository.impl;

import java.util.List;

import org.norsys.pamela.webhookapi.repository.interfaces.VaccinRepository;
import org.norsys.pamela.webhookapi.repository.rowmappers.NomVaccinRM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VaccinRepositoryImpl implements VaccinRepository {
	
	@Autowired
	public JdbcTemplate jt;

	@Override
	public List<String> tousLesVaccins() {
		String TOUS_LES_VACCINS = "SELECT nomvaccin FROM vaccin";
		RowMapper<String> vRowMapper = new NomVaccinRM();
		return jt.query(TOUS_LES_VACCINS, vRowMapper);
	}
	
	@Override
	public Boolean estObligatoire(String nomVaccin) {
		String EST_IL_OBLIGATOIRE = "SELECT estObligatoire FROM vaccin WHERE nomVaccin = ?";
		Object[] inputs = new Object[] {nomVaccin};
		return jt.queryForObject(EST_IL_OBLIGATOIRE, inputs,  Boolean.class);
	}

	
	
	
	@Override
	public List<String> vaccinParPays(String Pays) {
		String VACCINS_PAR_PAYS = "SELECT nomVaccin FROM vaccin WHERE Pays = ?";
		Object[] inputs = new Object[] {Pays};
		RowMapper<String> vRowMapper = new NomVaccinRM();
		return jt.query(VACCINS_PAR_PAYS, inputs, vRowMapper);
	}

}
