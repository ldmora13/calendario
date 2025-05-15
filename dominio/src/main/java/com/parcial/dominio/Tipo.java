package com.parcial.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    // --- Getters manuales ---

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    // --- Setters manuales ---

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
