package io.github.rhacs.reclutamiento.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.reclutamiento.modelos.Postulante;

@Repository
public interface PostulantesRepositorio extends JpaRepository<Postulante, Long> {

    /**
     * @return el último registro insertado en el repositorio, si existe
     */
    public Optional<Postulante> findTopByOrderByIdDesc();

}
