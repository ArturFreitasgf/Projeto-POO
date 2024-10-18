package Restaurante.MetodosPedido;

import Restaurante.Estruturas.PedidoStruct;
import Restaurante.Classes.Mesa;  

import java.util.List;

public class FecharPedido {

    public static void fecharPedido(List<PedidoStruct> pedidoList, Mesa mesa) {
        float total = calcularTotal(pedidoList);
        System.out.println("Total a pagar: R$ " + total);

        // Liberar a mesa
        mesa.setTableStatus(false);  
        System.out.println("Mesa " + mesa.getTableNum() + " foi liberada.");
    }

    private static float calcularTotal(List<PedidoStruct> pedidoList) {
        float total = 0;
        for (PedidoStruct pedido : pedidoList) {
            total += pedido.getProductValue() * pedido.getProductQuantity();  
        }
        return total;
    }
}
