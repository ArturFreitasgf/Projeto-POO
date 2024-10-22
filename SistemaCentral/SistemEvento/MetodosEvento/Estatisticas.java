package SistemEvento.MetodosEvento;

import java.util.List;

import SistemEvento.Classe.Evento;

public class Estatisticas {
    public static void exibirEventosMaiorTaxaParticipacao(List<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível para análise.");
            return;
        }

        // Exibir os eventos e suas respectivas taxas de participação
        System.out.println("\n----------Eventos e suas Taxas de Participação----------");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            double taxaParticipacao = (double) evento.getTotalparticipantes() / evento.getCapacidade() * 100;
            System.out.println(evento.getNomeevento() + " - " + String.format("%.2f", taxaParticipacao) + "% de participação");
        }
    }
}
