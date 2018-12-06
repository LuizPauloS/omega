package br.com.omega.omega.services;

import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.repository.PessoaRepository;
import br.com.omega.omega.exception.UnicidadeCPFException;
import br.com.omega.omega.services.imp.PessoaServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    private static final String NOME = "Luiz Silva";
    private static final String CPF = "111.111.111-11";

    @MockBean
    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;
    private Pessoa pessoa;

    @Before
    public void setUp() throws Exception {
        this.pessoaService = new PessoaServiceImp(pessoaRepository);
        this.pessoa = mockPessoaTest();
    }

    @Test
    public void testeDeveSalvarPessoa() throws Exception {
        this.pessoaService.savePessoa(pessoa);
        Mockito.verify(this.pessoaRepository).save(pessoa);
    }
    
    @Test(expected = UnicidadeCPFException.class)
    public void testeDeveRetornarExceptionAoTentarAdicionarDuasPessoasComMesmoCPF() throws Exception {
        Mockito.when(this.pessoaRepository.findPessoaByCpf(CPF)).thenReturn(pessoa);
        this.pessoaService.savePessoa(pessoa);
    }

    private Pessoa mockPessoaTest() {
        return new Pessoa(NOME, CPF);
    }

}
