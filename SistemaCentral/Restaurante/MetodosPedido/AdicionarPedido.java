package Restaurante.MetodosPedido;

import Restaurante.Estruturas.PedidoStruct;
import Restaurante.Classes.Mesa;
import java.util.Scanner;
import java.util.List;

public class AdicionarPedido {
    private static int idCounter = 0;

    public static int getId(){
        return idCounter;
    }

    public static void setIdCounter(){
        idCounter++;
    }

    public static void adicionarPedido(List<PedidoStruct> pedidoList, Scanner scanner, Mesa mesa){
        scanner.nextLine();
        System.out.println("Digite o nome do produto: ");
        String productName = scanner.nextLine();
        
        System.out.println("Digite a quantidade que deseja: ");
        while(!scanner.hasNextInt()){
            System.out.println("Digite uma quantidade válida.");
            scanner.next();
        }
        int productQuantity = scanner.nextInt();

        System.out.println("Digite o valor do produto: ");
        float productValue;
        do {
            while(!scanner.hasNextFloat()){
                System.out.println("Digite um valor válido.");
                scanner.next();
            }
            productValue = scanner.nextFloat();
        } while(productValue < 0);

        scanner.nextLine(); // Limpar o buffer

        // Adiciona o novo pedido à lista, incluindo a referência da mesa
        pedidoList.add(new PedidoStruct(productName, productValue, productQuantity, getId(), mesa));
        setIdCounter();
    }
}