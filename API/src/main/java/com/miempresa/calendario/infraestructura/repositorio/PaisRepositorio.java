package com.miempresa.calendario.infraestructura.repositorio;

import com.miempresa.calendario.dominio.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long> {
}
