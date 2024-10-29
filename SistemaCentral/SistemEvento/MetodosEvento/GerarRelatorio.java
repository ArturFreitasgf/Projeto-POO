package SistemEvento.MetodosEvento;

import java.util.List;
import java.util.Scanner;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Participante;

public class GerarRelatorio {
    public static void gerarRelatorio(Evento evento) {
        System.out.println("Evento: " + evento.getNomeevento());
        System.out.println("Data: " + evento.getDiaevento() + "/" + evento.getMesevento() + "/" + evento.getAnoevento());
        System.out.println("Local: " + evento.getLocal().getEndereco());
        System.out.println("Capacidade Máxima: " + evento.getCapacidade());
        System.out.println("Total de Participantes: " + evento.getTotalparticipantes());
        System.out.println("\n------------Lista de Participantes-------------");
        for (int i = 0; i < evento.getTotalparticipantes(); i++) {
            Participante p = evento.getParticipantes()[i];
            System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail() + ", Celular: " + p.getNumeroCelular());
        }
    }

    public static void gerarRelatorio(List<Evento> eventos, Scanner scan) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível para gerar relatório.");
        } else {
            System.out.println("\n----------Eventos Disponíveis para Relatório----------");
            for (int i = 0; i < eventos.size(); i++) {
                Evento ev = eventos.get(i);
                System.out.println((i + 1) + ") " + ev.getNomeevento() + " - " + ev.getDiaevento() + "/" + ev.getMesevento() + "/" + ev.getAnoevento());
            }

            System.out.print("Selecione o número do evento para gerar o relatório: ");
            int eventoIndex = scan.nextInt() - 1;
            scan.nextLine(); // Consumir a nova linha residual

            if (eventoIndex >= 0 && eventoIndex < eventos.size()) {
                Evento eventoSelecionado = eventos.get(eventoIndex);
                gerarRelatorio(eventoSelecionado);
            } else {
                System.out.println("Número de evento inválido.");
            }
        }
    }
}
