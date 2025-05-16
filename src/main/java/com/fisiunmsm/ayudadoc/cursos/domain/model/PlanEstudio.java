package com.fisiunmsm.ayudadoc.cursos.domain.model;

public class PlanEstudio {
    private Long id;
    private String codigo;
    private String descripcion;
    private String vigencia;
    private Long institucionId;
    private Long departamentoId;
    private String estado;
    private Long carreraId;
    
    public PlanEstudio(){
        
    }

    public PlanEstudio(Long id, String codigo, String descripcion, String vigencia, 
            Long institucionId, Long departamentoId, String estado,
            Long carreraId) {
        
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.vigencia = vigencia;
        this.institucionId = institucionId;
        this.departamentoId = departamentoId;
        this.estado = estado;
        this.carreraId = carreraId;
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

    public Long getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(Long institucionId) {
        this.institucionId = institucionId;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    
    
    // Método toString() para depuración
    @Override
    public String toString() {
        return "PlanEstudio{"
                + "id=" + id
                + ", codigo='" + codigo + '\''
                + ", descripcion='" + descripcion + '\''
                + ", vigencia='" + vigencia + '\''
                + ", institucionId=" + institucionId
                + ", departamentoId=" + departamentoId
                + ", estado='" + estado + '\''
                + ", carreraId=" + carreraId
                + '}';
    }
}
