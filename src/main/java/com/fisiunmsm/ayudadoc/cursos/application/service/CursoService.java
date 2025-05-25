package com.fisiunmsm.ayudadoc.cursos.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.fisiunmsm.ayudadoc.cursos.application.error.CursoNoEncontradoException;
import com.fisiunmsm.ayudadoc.cursos.domain.model.Curso;
import com.fisiunmsm.ayudadoc.cursos.domain.model.CursoCard;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.CursoTable;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.repository.CursoRepository;
import org.springframework.r2dbc.core.DatabaseClient;
//import com.fisiunmsm.ayudadoc.shared.config.Constantes;
//import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoService {
    private static final Logger LOGGER = Logger.getLogger(CursoService.class.getName());
    
    @Autowired
    private CursoRepository cursoRepository;
    private MessageSource mensajes;

    public Flux<Curso> obtenerCursosActivos() {
        return cursoRepository.queryCursosActivos().flatMap(CursoTable::toMono);
    }
    
    private final DatabaseClient databaseClient;

    public CursoService(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }
    
    public Flux<CursoCard> obtenerCursosCard() {
        String query = "SELECT c.id, c.codigo, c.nombre, d.codigo as departamentoNombre, "
                + "p.codigo as codigoPeriodo FROM curso c "
                + "INNER JOIN departamento d ON c.departamentoid = d.id "
                + "INNER JOIN periodoacademico p ON c.periodoacademicoid = p.id "
                + "WHERE c.estado = '1' ORDER BY c.nombre";

        return databaseClient.sql(query)
                .map((row, metadata) -> {
                    CursoCard dto = new CursoCard();
                    dto.setId(row.get("id", Long.class));
                    dto.setCodigo(row.get("codigo", String.class));
                    dto.setNombre(row.get("nombre", String.class));
                    dto.setDepartamentoNombre(row.get("departamentoNombre", String.class));
                    dto.setCodigoPeriodo(row.get("codigoPeriodo", String.class));
                    return dto;
                })
                .all();
    }
    
    
    // Método en el servicio para obtener los cursos de un ciclo específico

    public Mono<Curso> crearCurso( Curso curso ) {
        System.out.println(1);
        //AyudocLog.getInstance().debug("Ingresando a crer el curso: " + curso.getCodigo() );
        LOGGER.log(Level.INFO, "Ingresando a crear el curso: {0}", curso.getCodigo());

        Curso newCurso = curso;
        //newCurso.setEstado( Constantes.ACTIVO );
        //newCurso.setEstado( "1" );
        
        CursoTable cursoEntity = CursoTable.fromDomainModel( newCurso );

        //Mono<CursoTable> mc = cursoRepository.save(cursoEntity).doOnSuccess(pl -> {});
        //Mono<Curso> c = mc.map( c1 -> c1.toDomainModel() );
        //return c;
        
        return cursoRepository.save(cursoEntity).doOnSuccess(pl -> {}).map( c1 -> c1.toDomainModel() );
    }

    public Mono<Curso> actualizarCurso( Long id, Curso curso ) {
        System.out.println(2);
        //AyudocLog.getInstance().debug("Ingresando a actualizar curso: " + id );
        LOGGER.log(Level.INFO, "Ingresando a actualizar curso: {0}", id);

        return cursoRepository.findById(id)
            .switchIfEmpty(Mono.error(new CursoNoEncontradoException( mensajes, id.toString() )) )
            .flatMap( encontrado -> {

                encontrado.setId( id );
                if (curso.getCodigo()!=null) encontrado.setCodigo( curso.getCodigo() );
                if (curso.getNombre()!=null) encontrado.setNombre( curso.getNombre() );
                if (curso.getTipo()!=null) encontrado.setTipo( curso.getTipo() );                
                if (curso.getNumHorasTeoria()!=null) encontrado.setNumhorasteoria( curso.getNumHorasTeoria() );
                if (curso.getNumHorasPractica()!=null) encontrado.setNumhoraspractica( curso.getNumHorasPractica() );
                if (curso.getNumHorasLaboratorio()!=null) encontrado.setNumhoraslaboratorio( curso.getNumHorasLaboratorio() );
                if (curso.getNumCreditos()!=null) encontrado.setNumcreditos( curso.getNumCreditos() );
                if (curso.getPlanEstudiosId()!=null) encontrado.setPlanestudiosid( curso.getPlanEstudiosId() );
                if (curso.getCiclo()!=null) encontrado.setCiclo( curso.getCiclo() );
                if (curso.getPeriodoAcademicoId()!=null) encontrado.setPeriodoacademicoid( curso.getPeriodoAcademicoId() );
                if (curso.getInstitucionid()!=null) encontrado.setInstitucionid( curso.getInstitucionid() );
                if (curso.getDepartamentoid()!=null) encontrado.setDepartamentoid( curso.getDepartamentoid() );
                if (curso.getEstado()!=null) encontrado.setEstado( curso.getEstado() );
                if (curso.getSumilla()!=null) encontrado.setSumilla( curso.getSumilla() );
                if (curso.getModalidad()!=null) encontrado.setModalidad( curso.getModalidad() );
                if (curso.getEtiquetas()!=null) encontrado.setEtiquetas( curso.getEtiquetas() );

                return cursoRepository.save(encontrado).doOnSuccess(pl -> {}).map( c1 -> c1.toDomainModel() );
        });
    }

    public Mono<Curso> copiarCurso( Curso curso )   {

        //AyudocLog.getInstance().debug("Copiando el curso: " + curso.getId() );
        LOGGER.log(Level.INFO, "Copiando el curso: {0}", curso.getId());

        return cursoRepository.findById(curso.getId())
            .switchIfEmpty( Mono.error(new CursoNoEncontradoException( mensajes, curso.getId().toString() )) )
            .flatMap( encontrado -> {

                Curso nuevoCurso = new Curso();
                try {
        
                    nuevoCurso = (Curso)encontrado.toDomainModel().clone();
                    nuevoCurso.setCodigo( curso.getNuevoCodigo() );
                    if (curso.getNombre()!=null) nuevoCurso.setNombre( curso.getNombre() );
                    nuevoCurso.setEstado("COPIADO");
                    LOGGER.log(Level.INFO, nuevoCurso.toString());

                    //AyudocLog.getInstance().debug( nuevoCurso.toString() );
        
                } catch (CloneNotSupportedException e) {
                    
                    //AyudocLog.getInstance().error("Error en la copia: " + e.getMessage() );
                    LOGGER.log(Level.INFO, "Error en la copia: {0}", curso.getCodigo());

                    e.printStackTrace();
                }
                CursoTable cursoEntityNuevo = CursoTable.fromDomainModel( nuevoCurso );

                return cursoRepository.save(cursoEntityNuevo).doOnSuccess(pl -> {}).map( c1 -> c1.toDomainModel() );   
            });
            
    }

}
