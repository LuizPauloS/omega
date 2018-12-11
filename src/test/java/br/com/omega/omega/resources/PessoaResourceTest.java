package br.com.omega.omega.resources;

import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.services.imp.PessoaServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaResources.class)
public class PessoaResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private PessoaServiceImp pessoaServiceImp;

    @Before
    public void setUp() throws Exception {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(pessoaResources).build();
        Pessoa pessoa = this.mockPessoa();
        //Mockito.when(this.pessoaServiceImp.savePessoa(pessoa)).thenReturn(pessoa);
    }
    
    @Test
    public void testaGETListPessoas() throws Exception{
        Pessoa pessoa = this.mockPessoa();
        List<Pessoa> list = Arrays.asList(pessoa);
        Mockito.when(this.pessoaServiceImp.listPessoas()).thenReturn(list);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/pessoa/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome", Matchers.is("Marcos")));
    }
    
    @Test
    public void testaGETHello() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/pessoa/teste")
                .contentType(MediaType.ALL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome", Matchers.is("Marcos")));
    }
    
    
    @Test
    public void testaPOSTNewPessoa() throws Exception{
        Pessoa pessoa = this.mockPessoa();
        Mockito.when(this.pessoaServiceImp.savePessoa(pessoa)).thenReturn(pessoa);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/pessoa/save")
                .content(objectMapper.writeValueAsString(pessoa))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(201));
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome", Matchers.is("Marcos")));
    }
    
    private Pessoa mockPessoa(){
        return new Pessoa(1L, "Luiz", "111.111.111-11");
    }
}
