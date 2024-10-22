package SistemEvento.MetodosEvento;

import java.util.List;
import java.util.Scanner;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Participante;

public class AdicionarParticipante {
    public static boolean adicionarParticipante(Evento evento, Participante participante) {
        if (evento.getTotalparticipantes() < evento.getCapacidade()) {
            evento.getParticipantes()[evento.getTotalparticipantes()] = participante;
            evento.setTotalparticipantes(evento.getTotalparticipantes() + 1);
            return true;
        } else {
            return false;
        }
    }
    
    public static void adicionarParticipantes(Scanner scan, Evento evento) {
        String continuar;
        do {
            if (evento.estaLotado()) {
                System.out.println("Limite de participantes atingido.");
                break;
            }

            // Coleta informações do participante
            Participante participante = InfoParticipantes.coletarInformacoesParticipante(scan);
            if (adicionarParticipante(evento, participante)) {
                System.out.println("Participante registrado com sucesso.");
            }

            System.out.print("Deseja adicionar outro participante? (sim/nao): ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("sim"));

        // Geração do Relatório
        System.out.println("\n----------Gerando Relatório do Evento----------");
        GerarRelatorio.gerarRelatorio(evento);
    }

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
                adicionarParticipantes(scan, eventoSelecionado);  // Adiciona participantes ao evento selecionado
            } else {
                System.out.println("Número de evento inválido.");
            }
        }
    }   
}
