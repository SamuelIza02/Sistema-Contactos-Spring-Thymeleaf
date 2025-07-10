package com.contactos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para el sistema de contactos
 * Esta clase contiene el método main que inicia toda la aplicación
 */
@SpringBootApplication // Anotación que habilita la configuración automática de Spring Boot
public class ContactosApplication {

	/**
	 * Método principal que ejecuta la aplicación Spring Boot
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot con la configuración de esta clase
		SpringApplication.run(ContactosApplication.class, args);
	}

}
