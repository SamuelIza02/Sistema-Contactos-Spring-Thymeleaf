package com.contactos.servicio;

import com.contactos.modelo.Contacto;

import java.util.List;

/**
 * Interfaz que define los servicios disponibles para la gestión de contactos
 * Establece el contrato que debe cumplir cualquier implementación del servicio
 */
public interface IContactoServicio {
    
    /**
     * Obtiene la lista completa de todos los contactos
     * @return Lista de objetos Contacto
     */
    public List<Contacto> listarContactos();

    /**
     * Busca un contacto específico por su ID
     * @param idContacto ID del contacto a buscar
     * @return Objeto Contacto encontrado o null si no existe
     */
    public Contacto buscarContactoPorId(Integer idContacto);

    /**
     * Guarda un nuevo contacto o actualiza uno existente
     * @param contacto Objeto Contacto a guardar
     */
    public void guardarContacto(Contacto contacto);

    /**
     * Elimina un contacto de la base de datos
     * @param contacto Objeto Contacto a eliminar
     */
    public void eliminarContacto(Contacto contacto);
}
