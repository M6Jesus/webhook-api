package org.norsys.pamela.webhookapi.repository.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * Rowmapper pour l'extraction des valeurs de la
 * colonne nomVaccin de la table Vaccin
 * @author panou
 *
 */
public class NomVaccinRM implements RowMapper<String>{

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString(1);
	}

}
