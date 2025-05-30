
package com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

@Table("cursocompetencia")
public class CursoCompetenciaTable {
    
   @Id
   private Long id;
   
   private Long cursoid;
   private Long competenciaid;
   
   public CursoCompetenciaTable(){
       
   }

    public CursoCompetenciaTable(Long id, Long cursoid, Long competenciaid) {
        this.id = id;
        this.cursoid = cursoid;
        this.competenciaid = competenciaid;
    }
   
    public CursoCompetenciaTable toDomainModel(){
        return new CursoCompetenciaTable(id, cursoid, competenciaid);
    }
    
    public Mono<CursoCompetenciaTable> toMono(){
        return Mono.just(toDomainModel());
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
