package com.fisiunmsm.ayudadoc.cursos.domain.model;


public class CursoCard  {

    private Long id;

    private String codigo;
    private String nombre;
    private String departamentoNombre; 
    private String codigoPeriodo;


    public CursoCard()  {
    }

    public CursoCard(Long id, String codigo, String nombre, String departamentoNombre, String codigoPeriodo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamentoNombre = departamentoNombre;
        this.codigoPeriodo = codigoPeriodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }
 
}
