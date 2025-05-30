package com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper;

import com.fisiunmsm.ayudadoc.cursos.domain.model.ComponenteCompetencia;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

@Table("componentecompetencia")
public class ComponenteCompetenciaTable {
    
    @Id
    private Long id;
    
    private Long cursocompetenciaid;
    
    public ComponenteCompetenciaTable(){
        
    }

    public ComponenteCompetenciaTable(Long id, Long cursocompetenciaid) {
        this.id = id;
        this.cursocompetenciaid = cursocompetenciaid;
    }
    
    public ComponenteCompetencia toDomainModel() {
        return new ComponenteCompetencia(id, cursocompetenciaid);
    }

    public Mono<ComponenteCompetencia> toMono() {
        return Mono.just(toDomainModel());
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
