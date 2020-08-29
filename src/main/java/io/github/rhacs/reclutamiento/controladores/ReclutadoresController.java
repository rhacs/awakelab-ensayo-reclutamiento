package io.github.rhacs.reclutamiento.controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.rhacs.reclutamiento.Metodos;
import io.github.rhacs.reclutamiento.modelos.Oferta;
import io.github.rhacs.reclutamiento.modelos.Reclutador;
import io.github.rhacs.reclutamiento.repositorios.OfertasRepositorio;
import io.github.rhacs.reclutamiento.repositorios.ReclutadoresRepositorio;

@Controller
@RequestMapping(path = "/reclutadores")
public class ReclutadoresController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Objeto {@link ReclutadoresRepositorio} que contiene los métodos de
     * manipulación y consulta para el repositorio de {@link Reclutador}es
     */
    @Autowired
    private ReclutadoresRepositorio reclutadoresRepositorio;

    /**
     * Objeto {@link OfertasRepositorio} que contiene los métodos de manipulación y
     * consulta para el repositorio de {@link Oferta}s
     */
    @Autowired
    private OfertasRepositorio ofertasRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el formulario para agregar un nuevo {@link Reclutador}
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping
    public String mostrarFormulario(Model modelo) {
        // Agregar nueva instancia de Reclutador al modelo
        modelo.addAttribute("reclutador", new Reclutador());

        // Devolver vista
        return "reclutadores";
    }

    /**
     * Muestra el formulario para agregar una nueva {@link Oferta}
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping(path = "/ofertas")
    public String formularioOfertas(Model modelo) {
        // Agregar nueva instancia vacía de Oferta al modelo
        modelo.addAttribute("oferta", new Oferta());

        // Devolver vista
        return "reclutadores.ofertas";
    }

    /**
     * Muestra los {@link Postulante}s por cada {@link Oferta} disponible en el
     * repositorio
     * 
     * @param modelo objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @GetMapping(path = "/postulantes")
    public String mostrarPostulantes(Model modelo) {
        // Buscar listado de las ofertas
        List<Oferta> ofertas = Metodos.buscarOfertas();

        // Agregar listado al modelo
        modelo.addAttribute("ofertas", ofertas);

        // Devolver vista
        return "reclutadores.postulantes";
    }

    // Solicitudes POST
    // -----------------------------------------------------------------------------------------

    /**
     * Agrega un nuevo {@link Reclutador} al repositorio
     * 
     * @param reclutador    objeto {@link Reclutador} que contiene la información a
     *                      agregar
     * @param bindingResult objeto {@link BindingResult} que contiene los errores de
     *                      validación
     * @param modelo        objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @PostMapping
    public String agregarReclutador(@Valid Reclutador reclutador, BindingResult bindingResult, Model modelo) {
        // Verificar si hay errores
        if (bindingResult.hasErrors()) {
            // Devolver vista
            return "reclutadores";
        }

        // Obtener el último registro agregado al repositorio
        Optional<Reclutador> ultimo = reclutadoresRepositorio.findTopByOrderByIdDesc();

        // Verificar si existe
        if (ultimo.isPresent()) {
            // Asignar identificador basado en el último ingreso
            reclutador.setId(ultimo.get().getId() + 1L);
        } else {
            // Asignar identificador arbitrario
            reclutador.setId(1L);
        }

        // Guardar registro
        reclutadoresRepositorio.save(reclutador);

        // Redireccionar
        return "redirect:/reclutadores/?add=true";
    }

    /**
     * Agrega una nueva {@link Oferta} al repositorio
     * 
     * @param oferta        objeto {@link Oferta} que contiene la información a
     *                      agregar
     * @param bindingResult objeto {@link BindingResult} que contiene los errores de
     *                      validación
     * @param modelo        objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} que contiene el nombre de la vista
     */
    @PostMapping(path = "/ofertas")
    public String agregarOferta(@Valid Oferta oferta, BindingResult bindingResult, Model modelo) {
        // Verificar si hay errores
        if (bindingResult.hasErrors()) {
            // Buscar todos los reclutadores
            List<Reclutador> reclutadores = reclutadoresRepositorio.findAll(Sort.by(Order.asc("nombreFantasia")));

            // Agregar listado al modelo
            modelo.addAttribute("reclutadores", reclutadores);

            // Devolver vista
            return "reclutadores.ofertas";
        }

        // Obtener último registro insertado
        Optional<Oferta> ultima = ofertasRepositorio.findTopByOrderByIdDesc();

        // Verificar si existe
        if (ultima.isPresent()) {
            // Asignar identificador basado en el último
            oferta.setId(ultima.get().getId() + 1L);
        } else {
            // Asignar identificador arbitrario
            oferta.setId(1L);
        }

        // Guardar registro
        ofertasRepositorio.save(oferta);

        // Redireccionar
        return "redirect:/reclutadores/ofertas?add=true";
    }

}
