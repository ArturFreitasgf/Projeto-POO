package SistemEvento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.*;

import SistemEvento.MetodosEvento.*;
import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Local;

public class SistemaManager {
    
    private static List<Evento> eventos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LimparTela.limparTela();
        int valor;

        do{

            Cabecalhos.cabecalhoEventos();

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

            valor = scan.nextInt();
            scan.nextLine(); 

            switch (valor) {
                case 1:
                    // Cadastro de Local
                    LimparTela.limparTela();
                    Local local = CadastrarLocal.cadastrarLocal(scan);

                    // Cadastro de Evento
                    Evento evento = CadastrarEvento.cadastrarEvento(scan, local);

                    eventos.add(evento); // Adiciona o evento criado à lista de eventos
                    System.out.println("Evento criado com sucesso!");

                    // Adicionar participantes ao evento
                    AdicionarParticipante.adicionarParticipantes(scan, evento);
                    LimparTela.limparTela();
                    break;

                case 2:
                    LimparTela.limparTela();
                    AdicionarParticipante.adicionarParticipantes(eventos, scan);
                    break;

                case 3:
                    LimparTela.limparTela();
                    GerarRelatorio.gerarRelatorio(eventos, scan);
                    break;

                case 4:
                    LimparTela.limparTela();
                    Estatisticas.exibirEventosMaiorTaxaParticipacao(eventos);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(valor != 5);
    }
}