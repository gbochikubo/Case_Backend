package com.example.casebackend.controller;

import com.example.casebackend.controller.dto.AtualizarPessoaDTO;
import com.example.casebackend.controller.dto.CriarPessoaDTO;
import com.example.casebackend.model.Pessoa;
import com.example.casebackend.service.PessoaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public Object buscarPessoaPorId(@PathVariable Long id) {
        try {
            return pessoaService.buscarPessoaPorId(id);
        } catch (Exception e) {
            String mensagem = "Erro ao buscar Pessoa";
            log.error(mensagem + ": " + e.getMessage());
            return mensagem;
        }
    }

    @GetMapping("/listar")
    public Object listarPessoas() {
        try {
            return pessoaService.buscarTodasPessoas();
        } catch (Exception ex) {
            String mensagem = "Erro ao listar pessoas";
            log.error(mensagem);
            return mensagem + ": " + ex.getMessage();
        }
    }

    @PostMapping(value = "/cadastrar")
    @ResponseBody
    public Object salvarPessoa(@RequestBody CriarPessoaDTO criarPessoaDTO){
        try {
            if(criarPessoaDTO.validaCriarPessoaDTO()){
                return "Parametros Invalidos";
            }else{

                Pessoa pessoa = criarPessoaDTO.criarPessoaDTOParaPessoa();
                pessoa.removeMascara();

                if(pessoa.getIdentificador().length() == 11){
                    pessoa.setTipoIdentificador("CPF");
                }
                else if(pessoa.getIdentificador().length() == 14){
                    pessoa.setTipoIdentificador("CNPJ");
                }
                else{
                    return "Identificador invalido";
                }

                return pessoaService.salvarPessoa(pessoa);
            }
        } catch (Exception e) {
            String mensagem = "Erro ao salvar pessoa";
            log.error(mensagem + ": " + e.getMessage());
            return mensagem;
        }
    }

    @PutMapping(value = "/atualizar")
    @ResponseBody
    public Object atualizarPessoa(@RequestBody AtualizarPessoaDTO atualizarPessoaDTO){
        try {
            if(atualizarPessoaDTO.validaAtualizarPessoaDTO()){
                return "Parametros invalidos";
            }

            if(!pessoaService.verificaExistenciaPessoaPorId(atualizarPessoaDTO.getId())){
                return "Pessoa não localizada";
            }

            Pessoa pessoa = atualizarPessoaDTO.atualizaPessoaDTOParaPessoa();
            pessoa.removeMascara();

            if(pessoa.getIdentificador().length() == 11){
                pessoa.setTipoIdentificador("CPF");
            }
            else if(pessoa.getIdentificador().length() == 14){
                pessoa.setTipoIdentificador("CNPJ");
            }
            else{
                return "Identificador invalido";
            }

            return pessoaService.salvarPessoa(pessoa);
        } catch (Exception e) {
            String mensagem = "Erro ao atualizar pessoa";
            log.error(mensagem + ": " + e.getMessage());
            return mensagem;
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Object removerPessoaPorId(@PathVariable("id") Long idPessoa){
        try {
            pessoaService.removerPessoaPorId(idPessoa);
            return "Pessoa removida com sucesso.";
        } catch (Exception e) {
            String mensagem = "Erro ao remover pessoa";
            log.error(mensagem + ": " + e.getMessage());
            return mensagem;
        }
    }

}
