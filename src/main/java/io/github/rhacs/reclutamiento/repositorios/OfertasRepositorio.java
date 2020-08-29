package io.github.rhacs.reclutamiento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.reclutamiento.modelos.Oferta;

@Repository
public interface OfertasRepositorio extends JpaRepository<Oferta, Long> {

}
