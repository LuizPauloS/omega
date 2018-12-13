package br.com.omega.resources;

import br.com.omega.model.Profissional;
import br.com.omega.services.imp.ProfissionalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profissional")

public class ProfissionalResources {

    @Autowired
    private ProfissionalServiceImp profissionalService;

    @GetMapping("/testeProfissinal")
    public ResponseEntity<?> testeProfissional(){
        Boolean deuCerto = true;
        if (deuCerto == true){
            return ResponseEntity.ok("Deu Certo");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")//create
    public ResponseEntity<Profissional> saveProfissional(@RequestBody Profissional profissional){
        return ResponseEntity.ok(this.profissionalService.saveProfissional(profissional));
    }

    @GetMapping("/listProfissional")//read
    public ResponseEntity<List<?>> getListProfissional(){
        return new ResponseEntity<>(this.profissionalService.listProfissinal(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idProfissional}")//delete
    public ResponseEntity<?> deleteProfissional(@PathVariable("idProfissional") Long id){
        Profissional profissional = this.profissionalService.findProfissionalById(id);
        if (profissional != null){
            this.profissionalService.deleteProfissional(profissional);
            return ResponseEntity.ok("Deletado com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{idProfissional}")//update
    public ResponseEntity<?> updateProfissional(@PathVariable("idProfissional") Long id, @RequestBody Profissional profissionalAtual){
        Profissional profissional = this.profissionalService.findProfissionalById(id);
        if (profissional != null){
            profissional.setNome(profissionalAtual.getNome());
            this.profissionalService.updateProfissional(profissional);
            return ResponseEntity.ok("Atualizado com sucesso");
        }
        return ResponseEntity.ok("Profissional não Encontrado");
    }
}
