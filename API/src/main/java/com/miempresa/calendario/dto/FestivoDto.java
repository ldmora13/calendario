package com.miempresa.calendario.dto;

public class FestivoDto {

    private Long id;
    private String nombre;
    private int dia;
    private int mes;
    private int diasPascua;
    private String paisNombre;
    private String tipoNombre;


    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getDia() { return dia; }
    public void setDia(int dia) { this.dia = dia; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public int getDiasPascua() { return diasPascua; }
    public void setDiasPascua(int diasPascua) { this.diasPascua = diasPascua; }

    public String getPaisNombre() { return paisNombre; }
    public void setPaisNombre(String paisNombre) { this.paisNombre = paisNombre; }

    public String getTipoNombre() { return tipoNombre; }
    public void setTipoNombre(String tipoNombre) { this.tipoNombre = tipoNombre; }
}
