package com.fisiunmsm.ayudadoc.cursos.application.service;

import com.fisiunmsm.ayudadoc.cursos.domain.model.PlanEstudio;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.PlanEstudioTable;
import com.fisiunmsm.ayudadoc.cursos.infraestructure.repository.PlanEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PlanEstudioService {
    
    private final PlanEstudioRepository planestudioRepository;

    // Inyección de dependencias correcta (por constructor)
    @Autowired
    public PlanEstudioService(PlanEstudioRepository planestudioRepository) {
        this.planestudioRepository = planestudioRepository;
    }

    // Método para obtener planes de estudio activos
    public Flux<PlanEstudio> obtenerPlanEstudioActivos() {
        return planestudioRepository.queryPlanEstudioActivo()
                .map(this::convertirAPlanEstudio); // Conversión directa a PlanEstudio
    }

    // Método privado para convertir PlanEstudioTable a PlanEstudio
    private PlanEstudio convertirAPlanEstudio(PlanEstudioTable table) {
        return new PlanEstudio(
                table.getId(),
                table.getCodigo(),
                table.getDescripcion(),
                table.getVigencia(),
                table.getInstitucionid(),
                table.getDepartamentoid(),
                table.getEstado(),
                table.getCarreraid()
        );
    }
}
