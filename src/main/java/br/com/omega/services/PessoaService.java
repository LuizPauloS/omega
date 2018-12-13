package br.com.omega.services;

import br.com.omega.model.wrapper.UsuarioWrapper;
import br.com.omega.exception.UnicidadeCPFException;
import br.com.omega.model.Pessoa;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PessoaService {
    
    Pessoa login(UsuarioWrapper usuarioWrapper);
    
    Pessoa savePessoa(Pessoa pessoa) throws UnicidadeCPFException;
    
    List<Pessoa> listPessoas();
    
    Pessoa findPessoaById(Long id);
    
    Pessoa findPessoaByCpf(String cpf);
    
    void deletePessoa(Pessoa pessoa);
    
    Pessoa updatePessoa(Pessoa pessoa);
}
