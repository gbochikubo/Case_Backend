package com.example.casebackend.service;

import com.example.casebackend.model.Pessoa;
import com.example.casebackend.repository.PessoaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository perssoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa) throws Exception{
        try{
            return perssoaRepository.save(pessoa);
        }catch (Exception e){
            String mensagem = "Erro ao executar salvarPessoa: " + pessoa.getId();
            log.error(mensagem, e);
            throw new Exception(e);
        }
    }

    public Pessoa buscarPessoaPorId(Long idPessoa) throws Exception{
        try{
            return perssoaRepository.getById(idPessoa);
        }catch (Exception e) {
            String mensagem = "Erro ao executar buscarPessoaPorId: " + idPessoa;
            log.error(mensagem, e);
            throw new Exception(e);
        }
    }

    public List<Pessoa> buscarTodasPessoas() throws Exception{
        try{
            return perssoaRepository.findAll();
        }catch (Exception e){
            String mensagem = "Erro ao executar buscarTodasPessoas";
            log.error(mensagem, e);
            throw new Exception(e);
        }
    }

    public void removerPessoaPorId(Long idPessoa) throws Exception{
        try{
            Pessoa pessoa = buscarPessoaPorId(idPessoa);
            perssoaRepository.delete(pessoa);
        }catch (Exception e){
            String mensagem = "Erro ao executar removerPessoaPorId: " + idPessoa;
            log.error(mensagem, e);
            throw new Exception(e.getMessage());
        }
    }

    public boolean verificaExistenciaPessoaPorId(Long idPessoa) throws Exception{
        try{
            Optional<Pessoa> pessoa = perssoaRepository.findById(idPessoa);
            return pessoa.isPresent();
        }catch (Exception e){
            String mensagem = "Erro ao executar verificaExistenciaPessoaPorId: " + idPessoa;
            log.error(mensagem, e);
            throw new Exception(e.getMessage());
        }
    }
}
