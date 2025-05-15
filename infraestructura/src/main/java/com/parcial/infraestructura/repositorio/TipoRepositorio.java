package com.parcial.infraestructura.repositorio;

import com.parcial.dominio.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepositorio extends JpaRepository<Tipo, Long> {
}
