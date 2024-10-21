package Restaurante.MetodosPedido;

import Restaurante.Estruturas.PedidoStruct;
import java.util.List;
import java.util.Scanner;

public class CancelarPedido {

    public static void cancelarPedido(List<PedidoStruct> pedidoList, Scanner scanner) {
        ListarPedidos.listarPedidos(pedidoList);

        System.out.println("Digite o ID do pedido que deseja cancelar: ");
        int id = scanner.nextInt();

        PedidoStruct pedidoParaRemover = null;
        for (PedidoStruct pedido : pedidoList) {
            if (pedido.getProductId() == id) {  // Encapsulamento
                pedidoParaRemover = pedido;
                break;
            }
        }

        if (pedidoParaRemover != null) {
            pedidoList.remove(pedidoParaRemover);
            System.out.println("Pedido removido com sucesso!");
        } else {
            System.out.println("ID do pedido não encontrado.");
        }
    }
}