package com.example.casebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Long id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="identificador")
    @NotNull
    private String identificador;

    @Column(name="tipoIdentificador")
    @NotNull
    private String tipoIdentificador;

    public void removeMascara(){
        this.identificador = this.identificador.replaceAll("[^0-9]+","");
    }

    public void verificaTipoIdentificador(){

    }
}
