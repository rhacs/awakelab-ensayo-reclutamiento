package io.github.rhacs.reclutamiento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.reclutamiento.modelos.Reclutador;

@Repository
public interface ReclutadoresRepositorio extends JpaRepository<Reclutador, Long> {

}
