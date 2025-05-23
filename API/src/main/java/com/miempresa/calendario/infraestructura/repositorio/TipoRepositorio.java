package com.miempresa.calendario.infraestructura.repositorio;

import com.miempresa.calendario.dominio.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepositorio extends JpaRepository<Tipo, Long> {
}
