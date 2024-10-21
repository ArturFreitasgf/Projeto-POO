package SistemEvento.MetodosEvento;

import java.util.Scanner;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Participante;

public class MetodoAddPartiEventoCriado {

    public static void adicionarParticipantes(Scanner scan, Evento evento) {
        String continuar;
        do {
            if (evento.estaLotado()) {
                System.out.println("Limite de participantes atingido.");
                break;
            }

            // Coleta informações do participante
            Participante participante = MetodoColetarInfoParticipante.coletarInformacoesParticipante(scan);
            if (MetodoAddParti.adicionarParticipante(evento, participante)) {
                System.out.println("Participante registrado com sucesso.");
            }

            System.out.print("Deseja adicionar outro participante? (sim/nao): ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("sim"));

        // Geração do Relatório
        System.out.println("\n----------Gerando Relatório do Evento----------");
        MetodoGerarRelatorio.gerarRelatorio(evento);
    }
    
}