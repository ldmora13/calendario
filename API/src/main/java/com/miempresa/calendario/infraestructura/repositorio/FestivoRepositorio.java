package com.miempresa.calendario.infraestructura.repositorio;

import com.miempresa.calendario.dominio.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FestivoRepositorio extends JpaRepository<Festivo, Long> {

    List<Festivo> findByPaisId(Long paisId);
}
