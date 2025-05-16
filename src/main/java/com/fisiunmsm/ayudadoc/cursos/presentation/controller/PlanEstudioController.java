package com.fisiunmsm.ayudadoc.cursos.presentation.controller;

import com.fisiunmsm.ayudadoc.cursos.application.service.PlanEstudioService;
import com.fisiunmsm.ayudadoc.cursos.domain.model.PlanEstudio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api-cur/v1/plan-estudios")
public class PlanEstudioController {
    private final PlanEstudioService service;

    public PlanEstudioController(PlanEstudioService service) {
        this.service = service;
    }

    @GetMapping("/activos")
    public Flux<PlanEstudio> getPlanEstudioActivos() {
        return service.obtenerPlanEstudioActivos();
    }
}
