package br.com.omega.omega.services;

import br.com.omega.omega.model.Agenda;
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
