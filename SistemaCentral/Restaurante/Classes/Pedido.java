package Restaurante.Classes;

import Restaurante.Estruturas.PedidoStruct;
import Restaurante.MetodosPedido.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private List<PedidoStruct> pedidoList;
    private List<Mesa> mesas; // Lista de mesas
    private Scanner scanner;

    public Pedido(Scanner leitor){
        this.pedidoList = new ArrayList<>();
        this.mesas = new ArrayList<>(); // Inicializa a lista de mesas
        this.scanner = leitor;
        inicializarMesas(); // Chama o método para inicializar as mesas
    }

    private void inicializarMesas() {
        // Inicializa um número fixo de mesas (por exemplo, 5 mesas)
        for (int i = 1; i <= 5; i++) {
            mesas.add(new Mesa(false, i)); // Todas as mesas começam livres
        }
    }

    public void menu(){
        int op;
        do {
            do {
                System.out.println("1) Gerar pedido.");
                System.out.println("2) Alterar pedido.");
                System.out.println("3) Cancelar pedido.");
                System.out.println("4) Listar pedidos.");
                System.out.println("5) Fechar pedido.");
                System.out.println("6) Gerar relatório de vendas.");
                System.out.println("0) Sair.");
                while (!scanner.hasNextInt()) {
                    System.out.println("Escolha a opção entre 0 e 6.");
                    scanner.next();
                }
                op = scanner.nextInt();
            } while (op < 0 || op > 6);
    
            scanner.nextLine(); // Limpar Buffer
    
            switch (op) {
                case 1: // gerar pedido
                    System.out.println("Escolha uma mesa (1 a " + mesas.size() + "): ");
                    int mesaId = scanner.nextInt();
                    Mesa mesa = getMesaById(mesaId);
                    if (mesa != null && !mesa.getTableStatus()) {
                        AdicionarPedido.adicionarPedido(pedidoList, scanner, mesa);
                        mesa.setTableStatus(true); // Marca a mesa como ocupada
                    } else {
                        System.out.println("Mesa inválida ou já ocupada.");
                    }
                    break;
                case 2: // alterar pedido
                    ListarPedidos.listarPedidos(pedidoList);
                    
                    int id;
                    do {
                        System.out.println("Digite o ID do produto que deseja alterar: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("ID inválido.");
                            scanner.next();
                        }
                        id = scanner.nextInt();
                    } while (id < 0);
    
                    scanner.nextLine();
                    AlterarPedido.alterarPedido(pedidoList, id, scanner);
                    break;
                case 3: // cancelar pedido
                    CancelarPedido.cancelarPedido(pedidoList, scanner);
                    break;
                case 4: // listar pedidos
                    ListarPedidos.listarPedidos(pedidoList);
                    break;
                case 5: // fechar pedido
                    System.out.println("Escolha a mesa para fechar o pedido (1 a " + mesas.size() + "): ");
                    int mesaFecharId = scanner.nextInt();
                    Mesa mesaFechar = getMesaById(mesaFecharId);
                    if (mesaFechar != null && mesaFechar.getTableStatus()) {
                        FecharPedido.fecharPedido(pedidoList, mesaFechar);
                    } else {
                        System.out.println("Mesa inválida ou não ocupada.");
                    }
                    break;
                case 6: // gerar relatório de vendas
                    GerarRelatorioVendas.gerarRelatorio(pedidoList);
                    break;
                case 0: // sair
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (op != 0);
    }
    
    private Mesa getMesaById(int mesaId) {
        for (Mesa mesa : mesas) {
            if (mesa.getTableNum() == mesaId) {
                return mesa; // Retorna a mesa correspondente
            }
        }
        return null; // Retorna null se a mesa não for encontrada
    }
}