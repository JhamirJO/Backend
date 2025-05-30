/*
package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.CursoComponenteTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CursoComponenteRepository extends R2dbcRepository<CursoComponenteTable, Long>{
    
    @Query("DELETE FROM cursocomponente WHERE cursoid = ?")
    Mono<Void> deleteByCursoId(Long cursoId);
    
}
*/
