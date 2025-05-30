
package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.CursoCompetenciaTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


public interface CursoCompetenciaRepository extends R2dbcRepository<CursoCompetenciaTable, Long>{
    
    @Query("DELETE FROM cursocompetencia WHERE cursoid = ?")
    Mono<Void> deleteByCursoId(Long cursoId);  
}
