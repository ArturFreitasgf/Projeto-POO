package Projetos.Restaurante.MetodosPedido;

import java.util.List;
import java.util.Scanner;

import Projetos.Restaurante.Estruturas.PedidoStruct;

public class AlterarPedido {
    public static void alterarPedido(List<PedidoStruct> pedidoList, int IDSearch, Scanner scanner){
        for(PedidoStruct pedido : pedidoList){
            if(pedido.getProductId() == IDSearch){
                System.out.println("Digite o nome do novo produto: ");
                pedido.setProductName(scanner.nextLine());

                System.out.println("Digite a quantidade o novo produto: ");
                int novaQuantidade;
                do{
                    while(!scanner.hasNextInt()){
                        System.out.println("A quantidade digitada é inválida.");
                        scanner.next();
                    }
                    novaQuantidade = scanner.nextInt();
                } while(novaQuantidade <= 0);
                pedido.setProductQuantity(novaQuantidade);

                float novoValor;
                do{
                    System.out.println("Digite o valor do novo produto: ");
                    while(!scanner.hasNextFloat()){
                        System.out.println("Digite um valor válido.");
                        scanner.next();
                    }
                    novoValor = scanner.nextFloat();
                } while(novoValor < 0);
            }
        }
    }
}
