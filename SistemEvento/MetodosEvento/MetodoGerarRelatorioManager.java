package SistemEvento.MetodosEvento;

import SistemEvento.Classe.Evento;
import java.util.List;  // Importar List
import java.util.Scanner;  // Importar Scanner

public class MetodoGerarRelatorioManager {

    public static void gerarRelatorio(List<Evento> eventos, Scanner scan) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível para gerar relatório.");
        } else {
            // Listar eventos disponíveis
            System.out.println("\n----------Eventos Disponíveis para Relatório----------");
            for (int i = 0; i < eventos.size(); i++) {
                Evento ev = eventos.get(i);
                System.out.println((i + 1) + ") " + ev.getNomeevento() + " - " + ev.getDiaevento() + "/" + ev.getMesevento() + "/" + ev.getAnoevento());
            }

            // Selecionar evento
            System.out.print("Selecione o número do evento para gerar o relatório: ");
            int eventoIndex = scan.nextInt() - 1;
            scan.nextLine(); // Consumir a nova linha residual

            if (eventoIndex >= 0 && eventoIndex < eventos.size()) {
                Evento eventoSelecionado = eventos.get(eventoIndex);
                MetodoGerarRelatorio.gerarRelatorio(eventoSelecionado);  // Gera o relatório para o evento selecionado
            } else {
                System.out.println("Número de evento inválido.");
            }
        }
    }
}
