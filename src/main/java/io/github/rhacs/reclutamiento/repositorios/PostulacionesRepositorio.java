package io.github.rhacs.reclutamiento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.reclutamiento.modelos.Postulacion;
import io.github.rhacs.reclutamiento.modelos.PostulacionesPK;

@Repository
public interface PostulacionesRepositorio extends JpaRepository<Postulacion, PostulacionesPK> {

}
