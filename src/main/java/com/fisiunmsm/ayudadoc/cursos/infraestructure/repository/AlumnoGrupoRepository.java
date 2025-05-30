
package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.AlumnoGrupoTable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;



public interface AlumnoGrupoRepository extends R2dbcRepository<AlumnoGrupoTable, Long> {

    @Query("""
        DELETE FROM alumnogrupo
        WHERE alumnocursoid IN (
            SELECT id FROM alumnocurso WHERE cursoid = ?
        )
    """)
    Mono<Void> deleteByCursoId(Long cursoId);
}
