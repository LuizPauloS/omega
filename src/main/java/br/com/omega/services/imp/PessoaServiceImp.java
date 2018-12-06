package br.com.omega.omega.services.imp;

import br.com.omega.omega.exception.UnicidadeCPFException;
import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.repository.PessoaRepository;
import br.com.omega.omega.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImp implements PessoaService {

    @Autowired
    private final PessoaRepository pessoaRepository;

    public PessoaServiceImp(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa savePessoa(Pessoa pessoa) throws UnicidadeCPFException{
        Pessoa pessoaEncontrada = findPessoaByCpf(pessoa.getCpf());
        if(pessoaEncontrada != null){
            throw new UnicidadeCPFException("Já existe uma pessoa com mesmo CPF no banco de dados!");
        }
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> listPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findPessoaById(Long id) {
        return pessoaRepository.findPessoaById(id);
    }

    @Override
    public void deletePessoa(Pessoa pessoa) {
        this.pessoaRepository.delete(pessoa);
    }

    @Override
    public Pessoa updatePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa findPessoaByCpf(String cpf) {
       return this.pessoaRepository.findPessoaByCpf(cpf);
    }
}
