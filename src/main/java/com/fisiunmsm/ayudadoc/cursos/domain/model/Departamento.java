
package com.fisiunmsm.ayudadoc.cursos.domain.model;


public class Departamento {
    private Long id;
    private String codigo;
    
    
    
    public Departamento(){
        
    }

    public Departamento(Long id, String codigo) {
        this.id = id;
        this.codigo = codigo;
        
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
    
}
