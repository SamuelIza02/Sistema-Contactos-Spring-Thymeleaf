package com.contactos.controlador;

import com.contactos.modelo.Contacto;
import com.contactos.servicio.ContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controlador principal que maneja todas las peticiones HTTP relacionadas con contactos
 * Implementa el patrón MVC (Modelo-Vista-Controlador) de Spring
 * Coordina entre la capa de servicio y las vistas Thymeleaf
 */
@Controller // Marca esta clase como controlador de Spring MVC
public class ContactoControlador {

    // Logger para registrar eventos y depuración
    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);

    /**
     * Inyección de dependencia del servicio de contactos
     * Spring automáticamente proporciona una instancia del servicio
     */
    @Autowired
    ContactoServicio contactoServicio;

    /**
     * Maneja peticiones GET a la raíz ("/") - Página principal
     * Muestra la lista completa de contactos
     */
    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        // Obtiene todos los contactos del servicio
        List<Contacto> contactos = contactoServicio.listarContactos();
        // Registra cada contacto en el log para depuración
        contactos.forEach((contacto -> logger.info(contacto.toString())));
        // Añade la lista de contactos al modelo para que esté disponible en la vista
        modelo.put("contactos", contactos);
        return "index"; // Retorna la vista index.html
    }

    /**
     * Maneja peticiones GET a "/agregar" - Muestra formulario para nuevo contacto
     */
    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar"; // Retorna la vista agregar.html
    }

    /**
     * Maneja peticiones POST a "/agregar" - Procesa el formulario de nuevo contacto
     * @param contacto Objeto contacto creado automáticamente desde los datos del formulario
     */
    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto){
        logger.info("Contacto a agregar: " + contacto);
        // Guarda el nuevo contacto usando el servicio
        contactoServicio.guardarContacto(contacto);
        return "redirect:/"; // Redirige a la página principal después de guardar
    }

    /**
     * Maneja peticiones GET a "/editar/{id}" - Muestra formulario de edición
     * @param idContacto ID del contacto extraído de la URL
     * @param modelo Modelo para pasar datos a la vista
     */
    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idContacto, ModelMap modelo){
        // Busca el contacto por ID
        Contacto contacto = contactoServicio.buscarContactoPorId(idContacto);
        logger.info("Contacto a editar: " + contacto);
        // Añade el contacto al modelo para pre-llenar el formulario
        modelo.put("contacto", contacto);
        return "editar"; // Retorna la vista editar.html
    }

    /**
     * Maneja peticiones POST a "/editar" - Procesa la actualización del contacto
     * @param contacto Objeto contacto con los datos actualizados del formulario
     */
    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") Contacto contacto){
        logger.info("Contacto a guardar: " + contacto);
        // Actualiza el contacto existente
        contactoServicio.guardarContacto(contacto);
        return "redirect:/"; // Redirige a la página principal
    }

    /**
     * Maneja peticiones GET a "/eliminar/{id}" - Elimina un contacto
     * @param idContacto ID del contacto a eliminar extraído de la URL
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idContacto){
        // Crea un objeto contacto temporal solo con el ID para eliminación
        Contacto contacto = new Contacto();
        contacto.setIdContacto(idContacto);
        // Elimina el contacto usando el servicio
        contactoServicio.eliminarContacto(contacto);
        return "redirect:/"; // Redirige a la página principal
    }
}
