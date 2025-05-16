
package com.fisiunmsm.ayudadoc.cursos.presentation.controller;

import com.fisiunmsm.ayudadoc.cursos.application.service.DepartamentoService;
import com.fisiunmsm.ayudadoc.cursos.domain.model.Departamento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
    @RequestMapping("/api-cur/v1/departamento")
public class DepartamentoController {
    private final DepartamentoService service;
    
    public DepartamentoController(DepartamentoService service){
        this.service = service;
    }
    
    @GetMapping("/dp")
    public Flux<Departamento> getDepartamento(){
        return service.obtenerDepartamento();
    }
}
