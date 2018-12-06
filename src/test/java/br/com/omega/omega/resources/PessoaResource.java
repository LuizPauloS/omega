package br.com.omega.omega.resources;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class PessoaResource {

    private MockMvc mockMvc;
    
    @Autowired
    private PessoaResources pessoaResources;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(pessoaResources).build();
    }
}
