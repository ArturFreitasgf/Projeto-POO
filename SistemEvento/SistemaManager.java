package SistemEvento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SistemEvento.MetodosEvento.Cabecalho;
import SistemEvento.MetodosEvento.MetodoAddPartiEventoCriado;
import SistemEvento.MetodosEvento.MetodoAddParticipantesManager;
import SistemEvento.MetodosEvento.MetodoCadastrarEvento;
import SistemEvento.MetodosEvento.MetodoCadastrarLocal;
import SistemEvento.MetodosEvento.MetodoTaxaParticiEvento;
import SistemEvento.MetodosEvento.MetodoGerarRelatorioManager;
import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Local;
import SistemEvento.UtilEvento.limpartela;

public class SistemaManager {

    // Lista de eventos criados
    private static List<Evento> eventos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        limpartela.limparTela();

        boolean continuarExecucao = true;  // Controla o loop do sistema

        while (continuarExecucao) {

            Cabecalho.exibirCabecalho();

            System.out.print("\n");
            System.out.println("////////////////////////////////////////////");
            System.out.println("1) - Criar Evento");
            System.out.println("2) - Entrar em Evento");
            System.out.println("3) - Gerar Relatório");
            System.out.println("4) - Análise");
            System.out.println("5) - Sair");
            System.out.println("///////////////////////////////////////////");
            System.out.print("\n");
            System.out.print("Selecione uma das opções: ");

            int valor = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha residual após o nextInt()

            switch (valor) {
                case 1:
                    // Cadastro de Local
                    limpartela.limparTela();
                    Local local = MetodoCadastrarLocal.cadastrarLocal(scan);

                    // Cadastro de Evento
                    Evento evento = MetodoCadastrarEvento.cadastrarEvento(scan, local);

                    eventos.add(evento); // Adiciona o evento criado à lista de eventos
                    System.out.println("Evento criado com sucesso!");

                    // Adicionar participantes ao evento
                    MetodoAddPartiEventoCriado.adicionarParticipantes(scan, evento);
                    limpartela.limparTela();
                    break;

                case 2:
                    limpartela.limparTela();
                    MetodoAddParticipantesManager.adicionarParticipantes(eventos, scan);
                    break;

                case 3:
                    limpartela.limparTela();
                    MetodoGerarRelatorioManager.gerarRelatorio(eventos, scan);
                    break;

                case 4:
                    limpartela.limparTela();
                    MetodoTaxaParticiEvento.exibirEventosMaiorTaxaParticipacao(eventos);
                    break;

                case 5:
                    // Encerrar o loop e sair do programa
                    continuarExecucao = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scan.close();
    }

}