package SistemEvento.MetodosEvento;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Participante;

public class MetodoGerarRelatorio {
        public static void gerarRelatorio(Evento evento) {
        System.out.println("Evento: " + evento.getNomeevento());
        System.out.println("Data: " + evento.getDiaevento() + "/" + evento.getMesevento() + "/" + evento.getAnoevento());
        System.out.println("Local: " + evento.getLocal().getEndereco());
        System.out.println("Capacidade Máxima: " + evento.getCapacidade());
        System.out.println("Total de Participantes: " + evento.getTotalparticipantes());
        System.out.println("\n------------Lista de Participantes-------------");
        for (int i = 0; i < evento.getTotalparticipantes(); i++) {
            Participante p = evento.getParticipantes()[i];
            System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail() + ", Celular: " + p.getNumerocelular());
        }
    }   
}
