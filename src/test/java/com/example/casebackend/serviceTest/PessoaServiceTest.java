package com.example.casebackend.serviceTest;

import com.example.casebackend.model.Pessoa;
import com.example.casebackend.repository.PessoaRepository;
import com.example.casebackend.service.PessoaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository pessoaRepository;

    @Before
    public void iniciaMocks(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarPessoasTest() throws Exception{
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId((long) 1);
        pessoa1.setNome("Guilherme");
        pessoa1.setIdentificador("78579417511");
        pessoa1.setTipoIdentificador("CPF");

        Pessoa pessoa2 = new Pessoa();
        pessoa1.setId((long) 2);
        pessoa1.setNome("João");
        pessoa1.setIdentificador("98137623000105");
        pessoa1.setTipoIdentificador("CNPJ");

        Mockito.when(pessoaRepository.findAll()).thenReturn(Arrays.asList(pessoa1, pessoa2));

        List<Pessoa> pessoas = service.buscarTodasPessoas();

        Assert.assertEquals(2, pessoas.size());
    }

    @Test
    public void buscarPessoaPorIdTest() throws Exception{

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId((long) 1);
        pessoa1.setNome("Guilherme");
        pessoa1.setIdentificador("78579417511");
        pessoa1.setTipoIdentificador("CPF");

        Mockito.when(pessoaRepository.getById((long) 1)).thenReturn(pessoa1);

        Pessoa pessoa = service.buscarPessoaPorId((long) 1);

        Assert.assertEquals(pessoa1, pessoa);
    }


    @Test (expected = Exception.class)
    public void salvarPessoaDeveRetornarErroTest() throws Exception{

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId((long) 1);
        pessoa1.setNome("Guilherme");
        pessoa1.setIdentificador("123");
        pessoa1.setTipoIdentificador("CPF");

        service.salvarPessoa(pessoa1);
    }
}
