
package com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper;

import com.fisiunmsm.ayudadoc.cursos.domain.model.PlanEstudio;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

@Table("planestudios")
public class PlanEstudioTable {
    @Id
    private Long id;
    private String codigo;
    private String descripcion;
    private String vigencia;
    private Long institucionid;
    private Long departamentoid;
    private String estado;
    private Long carreraid;

    public PlanEstudioTable(){
        
    }
            
    public PlanEstudioTable(Long id, String codigo, String descripcion, String vigencia, 
            Long institucionid, Long departamentoid, String estado, Long carreraid) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.vigencia = vigencia;
        this.institucionid = institucionid;
        this.departamentoid = departamentoid;
        this.estado = estado;
        this.carreraid = carreraid;
    }
    
    // Método para convertir a modelo de dominio
    public PlanEstudio toDomainModel() {
        return new PlanEstudio(
                id,
                codigo,
                descripcion,
                vigencia,
                institucionid,
                departamentoid,
                estado,
                carreraid
        );
    }


    public Mono<PlanEstudio> toMono() {
        return Mono.just(toDomainModel());
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public Long getInstitucionid() {
        return institucionid;
    }

    public void setInstitucionid(Long institucionid) {
        this.institucionid = institucionid;
    }

    public Long getDepartamentoid() {
        return departamentoid;
    }

    public void setDepartamentoid(Long departamentoid) {
        this.departamentoid = departamentoid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCarreraid() {
        return carreraid;
    }

    public void setCarreraid(Long carreraid) {
        this.carreraid = carreraid;
    }

}
