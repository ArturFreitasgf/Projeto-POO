package SistemEvento.MetodosEvento;

import SistemEvento.Classe.Evento;

import java.util.List;
import java.util.Scanner;

public class MetodoAddParticipantesManager {
    public static void adicionarParticipantes(List<Evento> eventos, Scanner scan) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível. Crie um evento primeiro.");
        } else {
            // Listar eventos disponíveis
            System.out.println("\n----------Eventos Disponíveis----------");
            for (int i = 0; i < eventos.size(); i++) {
                Evento ev = eventos.get(i);
                System.out.println((i + 1) + ") " + ev.getNomeevento() + " - " + ev.getDiaevento() + "/" + ev.getMesevento() + "/" + ev.getAnoevento());
            }

            // Selecionar evento
            System.out.print("Selecione o número do evento: ");
            int eventoIndex = scan.nextInt() - 1;
            scan.nextLine(); // Consumir a nova linha residual

            if (eventoIndex >= 0 && eventoIndex < eventos.size()) {
                Evento eventoSelecionado = eventos.get(eventoIndex);
                MetodoAddPartiEventoCriado.adicionarParticipantes(scan, eventoSelecionado);  // Adiciona participantes ao evento selecionado
            } else {
                System.out.println("Número de evento inválido.");
            }
        }
    }   
}
