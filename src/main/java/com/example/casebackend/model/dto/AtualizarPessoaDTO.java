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
public class AtualizarPessoaDTO {

    private Long id;
    private String nome;
    private String identificador;

    public boolean validaAtualizarPessoaDTO(){
        if(this.id == null || this.nome == null || this.nome.isEmpty() || this.identificador == null || this.identificador.isEmpty()){
            return true;
        }
        return false;
    }

    public Pessoa atualizaPessoaDTOParaPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.id);
        pessoa.setNome(this.nome);
        pessoa.setIdentificador(this.identificador);
        return pessoa;
    }

}
