package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.domain.model.CursoDTO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.CursoTable;
import java.util.List;
import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CursoRepository extends R2dbcRepository<CursoTable, Long>  {
    
    Mono<CursoTable> findByCodigo(String codigo);

    @Query(value = "SELECT * FROM curso WHERE estado = '1' order by nombre")
    Flux<CursoTable> queryCursosActivos();
    
    @Query(value =  "SELECT c.id, c.codigo, c.nombre, d.codigo as departamentoNombre, c.seccion, "
           + "p.codigo as codigoPeriodo FROM curso c "
           + "INNER JOIN departamento d ON c.departamentoid = d.id "
           + "INNER JOIN periodoacademico p ON c.periodoacademicoid = p.id "
           + "WHERE c.estado = '1' ORDER BY c.nombre")
    Flux<Object[]> queryCursosLista();
}
