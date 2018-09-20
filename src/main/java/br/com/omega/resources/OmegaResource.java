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

    @GetMapping("/teste")
    public ResponseEntity<String> getOmegas(){
        boolean deucerto = true;
        if(deucerto) {
            return ResponseEntity.ok("HELLO WORD");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.ok(this.omegaService.savePessoa(pessoa));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pessoa>> getPessoasOmega(){
        return new ResponseEntity<>(this.omegaService.listPessoa(), HttpStatus.OK);
    }
}
