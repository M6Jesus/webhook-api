package org.norsys.pamela.webhookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * classe runner de l'application webhook-api
 * @author panou
 *
 */
@SpringBootApplication
public class WebhookApiRunner {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebhookApiRunner.class, args);
	}

}
