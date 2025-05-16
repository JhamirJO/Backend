
package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.DepartamentoTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface DepartamentoRepository extends R2dbcRepository<DepartamentoTable, Long> {
    
    Mono<DepartamentoTable> findByCodigo(String codigo);
    
    @Query("SELECT id, codigo FROM departamento")
    Flux<DepartamentoTable> queryDepartamento();
}
