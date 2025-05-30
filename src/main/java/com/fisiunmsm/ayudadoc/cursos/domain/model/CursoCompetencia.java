
package com.fisiunmsm.ayudadoc.cursos.domain.model;

public class CursoCompetencia {
    private Long id;
    private Long cursoid;
    private Long competenciaid;
    
    public CursoCompetencia(){
        
    }

    public CursoCompetencia(Long id, Long cursoid, Long competenciaid) {
        this.id = id;
        this.cursoid = cursoid;
        this.competenciaid = competenciaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursoid() {
        return cursoid;
    }

    public void setCursoid(Long cursoid) {
        this.cursoid = cursoid;
    }

    public Long getCompetenciaid() {
        return competenciaid;
    }

    public void setCompetenciaid(Long competenciaid) {
        this.competenciaid = competenciaid;
    }
}
