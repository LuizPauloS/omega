package br.com.omega.services;

import br.com.omega.model.Agenda;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AgendaService {

    List<Agenda> listAgendametos();
    
    Agenda saveAgendamento(Agenda agenda);

    Agenda findAgendaById(Long id);

    void removerAgendamento(Agenda agenda);

    Agenda updateAgendamentos(Agenda agendaBanco);
}
