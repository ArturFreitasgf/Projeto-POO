package Restaurante.Classes;

import Restaurante.Estruturas.PedidoStruct;
import Restaurante.MetodosPedido.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private List<PedidoStruct> pedidoList;
    private Scanner scanner;

    public Pedido(Scanner leitor){
        this.pedidoList = new ArrayList<>();
        this.scanner = leitor;
    }

    public void menu(){
        int op;
        do{
            do {
                System.out.println("1) Gerar pedido.");
                System.out.println("2) Alterar pedido.");
                System.out.println("3) Cancelar pedido.");
                System.out.println("4) Listar pedidos.");
                System.out.println("0) Sair.");
                while(!scanner.hasNextInt()){
                    System.out.println("Escolha a opção entre 1 e 3.");
                    scanner.next();
                }
                op = scanner.nextInt();
            } while(op < 0 || op > 4);
    
            scanner.nextLine(); // Limpar Buffer
    
            switch (op) {
                case 1: // pedido confirmado.
                    AdicionarPedido.adicionarPedido(pedidoList, scanner);
                    break;
                case 2: // alteração de pedido.
                    ListarPedidos.listarPedidos(pedidoList);
                    
                    int id;
                    do{
                        System.out.println("Digite o ID do produto que deseja alterar: ");
                        if(!scanner.hasNextInt()){
                            System.out.println("ID inválido.");
                            scanner.next();
                        }
                        id = scanner.nextInt();
                    } while(id < 0);

                    scanner.nextLine();

                    AlterarPedido.alterarPedido(pedidoList, id, scanner);
                    break;
                case 3: // cancelamento de produto.
                    break;
                case 4:
                    ListarPedidos.listarPedidos(pedidoList);
                case 0:
                    break;
            }
        } while(op != 0);
    }
}
