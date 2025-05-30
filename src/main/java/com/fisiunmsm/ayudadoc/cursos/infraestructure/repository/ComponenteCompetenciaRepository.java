
package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.ComponenteCompetenciaTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


public interface ComponenteCompetenciaRepository extends R2dbcRepository<ComponenteCompetenciaTable, Long>{
    
    @Query("DELETE FROM componentecompetencia "
            + "WHERE cursocompetenciaid IN ( "
            + "    SELECT id FROM cursocompetencia WHERE cursoid = ?"
            + ");")
    Mono<Void> deleteByCursoId(Long cursoId);
}
