/*
package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.AlumnoCursoTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


public interface AlumnoCursoRepository extends R2dbcRepository<AlumnoCursoTable, Long> {
    
    @Query("DELETE FROM alumnocurso WHERE cursoid = ?")
    Mono<Void> deleteByCursoId(Long cursoId);
    
}*/
