package br.com.omega.omega.services.imp;

import br.com.omega.omega.model.Agenda;
import br.com.omega.omega.repository.AgendaRepository;
import br.com.omega.omega.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImp implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public List<Agenda> listAgendametos() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda saveAgendamento(Agenda agenda) {
        return this.agendaRepository.save(agenda);
    }

    @Override
    public Agenda findAgendaById(Long id) {
        return agendaRepository.findAgendaById(id);
    }

    @Override
    public void removerAgendamento(Agenda agenda) {
        agendaRepository.delete(agenda);
    }

    @Override
    public Agenda updateAgendamentos(Agenda agendaBanco) {
        return this.agendaRepository.save(agendaBanco);
    }
}
