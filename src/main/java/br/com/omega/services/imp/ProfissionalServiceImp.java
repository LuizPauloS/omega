package br.com.omega.services.imp;

import br.com.omega.model.Profissional;
import br.com.omega.repository.ProfissionalRepository;
import br.com.omega.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalServiceImp implements ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Override
    public Profissional saveProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Override
    public Profissional findProfissionalById(Long id) {
        return profissionalRepository.findProfissionalById(id);
    }

    @Override
    public void deleteProfissional(Profissional profissional) {
        this.profissionalRepository.delete(profissional);
    }

    @Override
    public List<Profissional> listProfissinal() {
        return profissionalRepository.findAll();
    }

    @Override
    public Profissional updateProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }
}
