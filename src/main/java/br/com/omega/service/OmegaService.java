package br.com.omega.service;

import br.com.omega.model.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class OmegaService {

    public Pessoa savePessoa(Pessoa pessoa){
        return pessoa;
    }
}
