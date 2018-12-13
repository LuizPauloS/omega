package br.com.omega.repository;

import br.com.omega.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    Pessoa findPessoaByNomeIsLike(String nome);

    Pessoa findPessoaById(Long id);
    
    Pessoa findPessoaByCpf(String cpf);
}
