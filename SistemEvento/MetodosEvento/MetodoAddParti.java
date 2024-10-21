package SistemEvento.MetodosEvento;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Participante;

public class MetodoAddParti {
        public static boolean adicionarParticipante(Evento evento, Participante participante) {
        if (evento.getTotalparticipantes() < evento.getCapacidade()) {
            evento.getParticipantes()[evento.getTotalparticipantes()] = participante;
            evento.setTotalparticipantes(evento.getTotalparticipantes() + 1);
            return true;
        } else {
            return false;
        }
    }  
}