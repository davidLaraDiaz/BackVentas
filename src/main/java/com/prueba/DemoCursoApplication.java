package com.prueba;

import org.springframework.boot.ApplicationArguments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCursoApplication implements ApplicationRunner{

	private static final Logger logger = LogManager.getLogger(DemoCursoApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(DemoCursoApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.debug("Prueba Registro (log)");
        logger.info("Info log");
        logger.warn("Precaucion, This is a warning!");
        logger.error("Error! We have an Error. OK");
        logger.fatal("Fatal! Fatal error. Please fix me.");
		
	}

}
