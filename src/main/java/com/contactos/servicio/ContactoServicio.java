package com.contactos.servicio;

import com.contactos.modelo.Contacto;
import com.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación concreta del servicio de contactos
 * Contiene la lógica de negocio y actúa como intermediario entre
 * el controlador y el repositorio de datos
 */
@Service // Marca esta clase como un servicio de Spring para inyección de dependencias
public class ContactoServicio implements IContactoServicio{

    /**
     * Inyección de dependencia del repositorio de contactos
     * Spring automáticamente inyecta una instancia del repositorio
     */
    @Autowired
    private ContactoRepositorio contactoRepositorio;

    /**
     * Implementación para obtener todos los contactos de la base de datos
     */
    @Override
    public List<Contacto> listarContactos() {
        // Delega la operación al repositorio que maneja la persistencia
        return contactoRepositorio.findAll();
    }

    /**
     * Implementación para buscar un contacto por su ID
     * Utiliza Optional para manejar casos donde el contacto no existe
     */
    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        // findById retorna Optional<Contacto>, orElse(null) maneja el caso de no encontrado
        Contacto contacto = contactoRepositorio.findById(idContacto).orElse(null);
        return contacto;
    }

    /**
     * Implementación para guardar o actualizar un contacto
     * Si el ID es null, crea un nuevo registro; si existe, actualiza el existente
     */
    @Override
    public void guardarContacto(Contacto contacto) {
        // save() maneja tanto INSERT como UPDATE automáticamente
        contactoRepositorio.save(contacto);
    }

    /**
     * Implementación para eliminar un contacto de la base de datos
     */
    @Override
    public void eliminarContacto(Contacto contacto) {
        // Elimina el contacto usando el método delete del repositorio
        contactoRepositorio.delete(contacto);
    }
}
