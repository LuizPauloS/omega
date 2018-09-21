package br.com.omega.service;

import br.com.omega.model.Pessoa;
import br.com.omega.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmegaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa savePessoa(Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listPessoa() {
        return this.pessoaRepository.findAll();
    }

    public Pessoa findPessoaById(Long id){
        return this.pessoaRepository.findPessoaById(id);
    }

    public Pessoa updatePessoa(Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

}
