package Restaurante.MetodosPedido;

import Restaurante.Estruturas.PedidoStruct;
import Restaurante.Classes.Mesa;

import java.util.List;
import java.util.Scanner;

public class FecharPedido {

    public static void fecharPedido(List<PedidoStruct> pedidoList, Scanner scanner) {

        System.out.println("Digite o ID da mesa que quer fechar a conta: ");
        int mesaToClose = scanner.nextInt();

        float total = calcularTotal(pedidoList);
        System.out.println("Total a pagar: R$ " + total);

        Mesa mesa = new Mesa(false, mesaToClose);

        // Liberar a mesa
        mesa.setTableStatus(false);
        System.out.println("Mesa " + mesa.getTableNum() + " foi liberada.");
    }

    private static float calcularTotal(List<PedidoStruct> pedidoList) {
        float total = 0;
        for (PedidoStruct pedido : pedidoList) {
            total += pedido.getProductValue() * pedido.getProductQuantity();  // Encapsulamento
        }
        return total;
    }
}
