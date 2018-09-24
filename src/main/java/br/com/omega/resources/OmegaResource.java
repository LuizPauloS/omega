package br.com.omega.resources;

import br.com.omega.model.Pessoa;
import br.com.omega.service.OmegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/omega")
public class OmegaResource {

    @Autowired
    private OmegaService omegaService;

    @GetMapping("/hello-word")
    public ResponseEntity<String> getHelloWordOmega(){
        boolean deucerto = true;
        if(deucerto) {
            return ResponseEntity.ok("HELLO WORD");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save") //CREATE
    public ResponseEntity<Pessoa> savePessoaOmega(@RequestBody Pessoa pessoa){
        return ResponseEntity.ok(this.omegaService.savePessoa(pessoa));
    }

    @GetMapping("/list") //READ
    public ResponseEntity<List<Pessoa>> getPessoasOmega(){
        return new ResponseEntity<>(this.omegaService.listPessoa(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}") //UPDATE
    public ResponseEntity<?> updatePessoaOmega(@PathVariable("id") Long idPessoa, @RequestBody Pessoa pessoa){
        Pessoa p = this.omegaService.findPessoaById(idPessoa);
        if (p != null){
            p.setNome(pessoa.getNome());
            p.setCpf(pessoa.getCpf());
            return ResponseEntity.ok(this.omegaService.updatePessoa(p));
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}") //DELETE
    public ResponseEntity<?> deletePessoa(@PathVariable("id") Long idPessoa){
        Pessoa pessoa = this.omegaService.findPessoaById(idPessoa);
        if(pessoa != null){
            this.omegaService.deletePessoa(pessoa);
            return ResponseEntity.ok("Pessoa excluida com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
