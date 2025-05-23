/* 


package com.miempresa.calendario.dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festivo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "dia")
    private int dia;

    @Column(name = "mes")
    private int mes;

    @Column(name = "diaspascua")
    private int diasPascua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpais", referencedColumnName = "id", nullable = false)
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipo", referencedColumnName = "id", nullable = false)
    private Tipo tipo;
} */






package com.miempresa.calendario.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "festivo")
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "dia")
    private int dia;

    @Column(name = "mes")
    private int mes;

    @Column(name = "diaspascua")
    private int diasPascua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpais", referencedColumnName = "id", nullable = false)
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipo", referencedColumnName = "id", nullable = false)
    private Tipo tipo;

    // --- GETTERS ---

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public Pais getPais() {
        return pais;
    }

    public Tipo getTipo() {
        return tipo;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
