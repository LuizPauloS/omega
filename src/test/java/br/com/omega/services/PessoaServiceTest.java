package br.com.omega.services;

import br.com.omega.model.Pessoa;
import br.com.omega.repository.PessoaRepository;
import br.com.omega.exception.UnicidadeCPFException;
import br.com.omega.services.imp.PessoaServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    private static final String NOME = "Luiz Silva";
    private static final String CPF = "111.111.111-11";

//    @MockBean
//    private PessoaRepository pessoaRepository;
//    private PessoaService pessoaService;
    
    /*Para criar o Service, precisamos ter uma instância da classe Service criada e disponível como @Bean 
    para que possamos @Autowire em nossa classe de teste. Essa configuração é obtida usando a anotação @TestConfiguration.
    Durante a varredura de componentes, podemos encontrar componentes ou configurações criadas apenas para testes específicos
    que são acidentalmente detectados em todos os lugares. Para ajudar a evitar isso, o Spring Boot fornece a anotação @TestConfiguration 
    que pode ser usada em classes em src / test / java para indicar que elas não devem ser selecionadas pela varredura.*/
    @TestConfiguration
    static class PessoaServiceImplTestContextConfiguration {
  
        @Bean
        public PessoaService pessoaService() {
            return new PessoaServiceImp();
        }
    }
 
    @Autowired
    private PessoaService pessoaService;
 
    @MockBean
    private PessoaRepository pessoaRepository;
    
    private Pessoa pessoa;

    @Before
    public void setUp() throws Exception {
        //pessoaService = new PessoaServiceImp(pessoaRepository);
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
