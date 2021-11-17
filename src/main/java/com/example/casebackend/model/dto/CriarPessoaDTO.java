package com.example.casebackend.model.dto;

import com.example.casebackend.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarPessoaDTO {

    private String nome;
    private String identificador;

    public boolean validaCriarPessoaDTO(){
        if(this.nome == null || this.nome.isEmpty() || this.identificador == null || this.identificador.isEmpty()){
            return true;
        }
        return false;
    }

    public Pessoa criarPessoaDTOParaPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setIdentificador(this.identificador);
        return pessoa;
    }
}
