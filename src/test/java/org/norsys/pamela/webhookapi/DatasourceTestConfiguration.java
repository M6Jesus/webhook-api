/**
 * 
 */
package org.norsys.pamela.webhookapi;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * @author panou
 *
 */
@Configuration
public class DatasourceTestConfiguration {

	@Bean
	public Boolean initDatasource(final DataSource dataSource) {

		// schema init
		Resource initSchema = new ClassPathResource("dataH2.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);

		return Boolean.TRUE;
	}
}
