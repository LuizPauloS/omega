package br.com.omega.repository;

import br.com.omega.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findPessoaById(Long id);
//
//    @Query(nativeQuery = true, value = "select * from Pessoa where nome like '% :nome %'")
//    Pessoa findPessoaByName(@Param("nome") String nome);
}
