package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.PlanEstudioTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanEstudioRepository extends R2dbcRepository<PlanEstudioTable, Long> { 
    
    // Búsqueda por código específico
    Mono<PlanEstudioTable> findByCodigo(String codigo);

    
    @Query("SELECT * FROM planestudios WHERE estado = '1' ORDER BY descripcion")
    Flux<PlanEstudioTable> queryPlanEstudioActivo();
}
