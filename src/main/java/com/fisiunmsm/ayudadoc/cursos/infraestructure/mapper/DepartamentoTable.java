
package com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper;

import com.fisiunmsm.ayudadoc.cursos.domain.model.Departamento;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

@Table("departamento")
public class DepartamentoTable {
    @Id
    private Long id;
    private String codigo;

    
    public DepartamentoTable(){
        
    }

    public DepartamentoTable(Long id, String codigo) {
        this.id = id;
        this.codigo = codigo;

    }
    
    // Método para convertir a modelo de dominio
    public Departamento toDomainModel() {
        return new Departamento(
                id,
                codigo
                
        );
    }
    
    public Mono<Departamento> toMono(){
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
}
