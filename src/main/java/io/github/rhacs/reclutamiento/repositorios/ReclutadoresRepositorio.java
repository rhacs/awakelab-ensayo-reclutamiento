package io.github.rhacs.reclutamiento.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.reclutamiento.modelos.Reclutador;

@Repository
public interface ReclutadoresRepositorio extends JpaRepository<Reclutador, Long> {

    /**
     * @return el último registro ingresado al repositorio, si existe
     */
    public Optional<Reclutador> findTopByOrderByIdDesc();

}
