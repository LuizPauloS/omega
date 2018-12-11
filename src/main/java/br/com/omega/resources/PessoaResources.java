package br.com.omega.omega.resources;

import br.com.omega.omega.exception.BadRequestException;
import br.com.omega.omega.exception.UnicidadeCPFException;
import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.services.imp.PessoaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoaResources {

    @Autowired
    private PessoaServiceImp pessoaService;

    @GetMapping("/teste")
    public ResponseEntity<String> getOmegas(){
        boolean deuCerto = true;
        if (deuCerto){
            return ResponseEntity.ok("Hello World");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")//create
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        try {
            return ResponseEntity.status(201).body(this.pessoaService.savePessoa(pessoa));
        } catch (UnicidadeCPFException ex) {
            throw new BadRequestException("Erro ao inserir nova pessoa. " + ex.getMessage());
        }
    }
    @GetMapping("/list")//read
    public ResponseEntity<List<?>> getPessoaOmega(){
        return new ResponseEntity<>(this.pessoaService.listPessoas(), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{idPessoa}")//delete
    public ResponseEntity<?> deletePessoaOmega(@PathVariable("idPessoa") Long id){
        Pessoa pessoa = this.pessoaService.findPessoaById(id);
        if (pessoa != null){
            this.pessoaService.deletePessoa(pessoa);
            return ResponseEntity.ok("Deletado Com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{idPessoa}")//update
    public ResponseEntity<?> updatePessoaOmega(@RequestBody Pessoa pessoaAtual, @PathVariable("idPessoa") Long id){
        Pessoa pessoa = this.pessoaService.findPessoaById(id);
        if (pessoa != null){
            pessoa.setNome(pessoaAtual.getNome());
            pessoa.setCpf(pessoaAtual.getCpf());
            this.pessoaService.updatePessoa(pessoa);
            return ResponseEntity.ok("Atualizado com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }
}
