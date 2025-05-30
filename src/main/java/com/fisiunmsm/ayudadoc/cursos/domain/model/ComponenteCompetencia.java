
package com.fisiunmsm.ayudadoc.cursos.domain.model;


public class ComponenteCompetencia {
    private Long id;
    private Long cursocompetenciaid;
    
    public ComponenteCompetencia(){
        
    }

    public ComponenteCompetencia(Long id, Long cursocompetenciaid) {
        this.id = id;
        this.cursocompetenciaid = cursocompetenciaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursocompetenciaid() {
        return cursocompetenciaid;
    }

    public void setCursocompetenciaid(Long cursocompetenciaid) {
        this.cursocompetenciaid = cursocompetenciaid;
    }
    
}
