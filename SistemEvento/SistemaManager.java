package SistemEvento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import SistemEvento.MetodosEvento.Cabecalho;
import SistemEvento.MetodosEvento.MetodoAddPartiEventoCriado;
import SistemEvento.MetodosEvento.MetodoCadastrarEvento;
import SistemEvento.MetodosEvento.MetodoCadastrarLocal;
import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Local;


public class SistemaManager {

    // Lista de eventos criados
    private static List<Evento> eventos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Exibir cabeçalho
        Cabecalho.exibirCabecalho();

        boolean continuarExecucao = true;  // Controla o loop do sistema

        while (continuarExecucao) {
            System.out.print("\n");
            System.out.println("////////////////////////////////////////////");
            System.out.println("1) - Criar Evento");
            System.out.println("2) - Entrar em Evento");
            System.out.println("3) - Voltar ao Sistema Central");
            System.out.println("4) - Sair");
            System.out.println("///////////////////////////////////////////");
            System.out.print("\n");
            System.out.print("Selecione uma das opções: ");

            int valor = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha residual após o nextInt()

            switch (valor) {
                case 1:
                    // Cadastro de Local
                    Local local = MetodoCadastrarLocal.cadastrarLocal(scan);

                    // Cadastro de Evento
                    Evento evento = MetodoCadastrarEvento.cadastrarEvento(scan, local);

                    eventos.add(evento); // Adiciona o evento criado à lista de eventos
                    System.out.println("Evento criado com sucesso!");

                    // Adicionar participantes ao evento
                    MetodoAddPartiEventoCriado.adicionarParticipantes(scan, evento);
                    break;

                case 2:
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
                            MetodoAddPartiEventoCriado.adicionarParticipantes(scan, eventoSelecionado);
                        } else {
                            System.out.println("Número de evento inválido.");
                        }
                    }
                    break;
                
                case 3:
                    break;

                case 4:
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