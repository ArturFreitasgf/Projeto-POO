package SistemEvento;

import java.util.Scanner;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Local;
import SistemEvento.Classe.Participante;
import SistemEvento.MetodosEvento.Cabecalho;
import SistemEvento.MetodosEvento.MetodoEvento;

public class SistemaManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Exibir cabeçalho
        Cabecalho.exibirCabecalho();

        // Cadastro de Local
        Local local = MetodoEvento.cadastrarLocal(scan);

        // Cadastro de Evento
        Evento evento = MetodoEvento.cadastrarEvento(scan, local);

        String continuar;
        do {
            if (evento.estaLotado()) {  
                System.out.println("Limite de participantes atingido.");  
                break;  
            }

            // Coleta informações do participante
            Participante participante = MetodoEvento.coletarInformacoesParticipante(scan);
            if (MetodoEvento.adicionarParticipante(evento, participante)) {
                System.out.println("Participante registrado com sucesso.");
            }

            System.out.print("Deseja adicionar outro participante? (sim/nao): ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("sim"));

        // Geração do Relatório
        System.out.println("\n----------Gerando Relatório do Evento----------");
        MetodoEvento.gerarRelatorio(evento);

        scan.close();
    }
}
