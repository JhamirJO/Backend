
package com.fisiunmsm.ayudadoc.cursos.application.service;

import com.fisiunmsm.ayudadoc.cursos.domain.model.Departamento;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.DepartamentoTable;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;
    
    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository){
        this.departamentoRepository = departamentoRepository;
    }
    
    public Flux<Departamento> obtenerDepartamento(){
        return departamentoRepository.findAll()
                .map(DepartamentoTable::toDomainModel);
        
    }
}
