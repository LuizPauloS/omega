package br.com.omega.services;

import br.com.omega.model.Profissional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ProfissionalService {

    Profissional saveProfissional(Profissional profissional);

    Profissional findProfissionalById(Long id);

    void deleteProfissional(Profissional profissional);

    List<Profissional> listProfissinal();

    Profissional updateProfissional(Profissional profissional);
}
