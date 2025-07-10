package com.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entidad JPA que representa un contacto en la base de datos
 * Utiliza Lombok para generar automáticamente getters, setters y constructores
 */
@Entity // Marca esta clase como una entidad JPA para mapeo con base de datos
@Data // Lombok: genera getters, setters, equals, hashCode automáticamente
@NoArgsConstructor // Lombok: genera constructor sin parámetros
@AllArgsConstructor // Lombok: genera constructor con todos los parámetros
@ToString // Lombok: genera método toString() automáticamente
public class Contacto {

    /**
     * Identificador único del contacto (clave primaria)
     * Se genera automáticamente usando estrategia IDENTITY
     */
    @Id // Marca este campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento en BD
    Integer idContacto;
    
    /** Nombre completo del contacto */
    String nombre;
    
    /** Número de teléfono celular del contacto */
    String celular;
    
    /** Dirección de correo electrónico del contacto */
    String email;
}
