package com.contactos.repositorio;

import com.contactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para operaciones CRUD con la entidad Contacto
 * Extiende JpaRepository que proporciona métodos básicos como:
 * - findAll(): obtener todos los contactos
 * - findById(): buscar por ID
 * - save(): guardar/actualizar contacto
 * - delete(): eliminar contacto
 * 
 * @param <Contacto> Entidad que maneja este repositorio
 * @param <Integer> Tipo de dato de la clave primaria
 */
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {
    // Spring Data JPA genera automáticamente la implementación
    // No necesitamos escribir código adicional para operaciones básicas
}
