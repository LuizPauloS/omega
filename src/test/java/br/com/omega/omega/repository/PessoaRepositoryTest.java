package br.com.omega.omega.repository;

import br.com.omega.omega.OmegaApplicationTests;
import br.com.omega.omega.model.Pessoa;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:application-test.yml")
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Before
    public void init(){
        this.adicionarListaPessoas();
    }
    
    @Test
    public void testeDeveRetornarListaDePessoasAgenda() throws Exception{
        List<Pessoa> listPessoas = this.pessoaRepository.findAll();
        Assertions.assertThat(listPessoas).isNotNull().isNotEmpty();
    }
    
    @Test
    public void testeDeveAdicionarNovasPessoasAoBancoDeDados(){
        Pessoa pessoaAdd = this.pessoaRepository.save(mockPessoa());
        Assertions.assertThat(pessoaAdd).isNotNull();
        Assertions.assertThat(pessoaAdd.getId()).isNotNull();
    }
    
    private void adicionarListaPessoas() {
        List<Pessoa> listPessoasMock = this.mockListPessoas();
        for(Pessoa pessoa: listPessoasMock) {
            this.pessoaRepository.save(pessoa);
        }
    }
    
    private Pessoa mockPessoa(){
        return new Pessoa("Marcos da Silva", "555.555.555-55");
    }
    
    private List<Pessoa> mockListPessoas(){
        return Arrays.asList(new Pessoa("Luiz Silva", "111.111.111-11"),
                new Pessoa("Joana da Silva", "222.222.222-22"),
                new Pessoa("José da Silva", "333.333.333-33"),
                new Pessoa("Mariana da Silva", "444.444.444-44"));
    }
}
