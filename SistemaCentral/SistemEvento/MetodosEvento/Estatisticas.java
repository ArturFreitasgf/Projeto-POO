package SistemEvento.MetodosEvento;

import java.util.ArrayList;
import java.util.List;

import SistemEvento.Classe.Evento;

public class Estatisticas {
    public static void exibirEventosMaiorTaxaParticipacao(List<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível.");
            return;
        }

        double maiorTaxa = 0.0;
        List<Evento> eventosMaiorTaxa = new ArrayList<>();

        // Calcular a taxa de participação para cada evento e identificar o(s) com maior taxa
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            double taxaParticipacao = (double) evento.getTotalparticipantes() / evento.getCapacidade() * 100;

            // Verifica se o evento atual tem a maior taxa de participação
            if (taxaParticipacao > maiorTaxa) {
                maiorTaxa = taxaParticipacao;
                eventosMaiorTaxa.clear();  // Limpa a lista, pois temos um novo líder
                eventosMaiorTaxa.add(evento);  // Adiciona o novo evento com a maior taxa
            } else if (taxaParticipacao == maiorTaxa) {
                eventosMaiorTaxa.add(evento);  // Se for igual, adiciona na lista
            }
        }

        // Exibir os eventos com a maior taxa de participação
        System.out.println("\n----------Eventos com Maior Taxa de Participação----------");
        for (int i = 0; i < eventosMaiorTaxa.size(); i++) {
            Evento evento = eventosMaiorTaxa.get(i);
            double taxaParticipacao = (double) evento.getTotalparticipantes() / evento.getCapacidade() * 100;
            System.out.println(evento.getNomeevento() + " - " + taxaParticipacao + "% de participação");
        }
    }
}
