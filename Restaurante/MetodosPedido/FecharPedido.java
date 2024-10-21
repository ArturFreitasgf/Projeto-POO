package Restaurante.MetodosPedido;

import Restaurante.Estruturas.PedidoStruct;
import Restaurante.Classes.Mesa;  

import java.util.List;

public class FecharPedido {

    public static void fecharPedido(List<PedidoStruct> pedidoList, Mesa mesa) {
        // Filtra os pedidos associados à mesa
        float total = calcularTotal(pedidoList, mesa);
        System.out.println("Total a pagar: R$ " + total);

        // Liberar a mesa
        mesa.setTableStatus(false);  
        System.out.println("Mesa " + mesa.getTableNum() + " foi liberada.");
    }

    private static float calcularTotal(List<PedidoStruct> pedidoList, Mesa mesa) {
        float total = 0;
        for (PedidoStruct pedido : pedidoList) {
            // Somente conta os pedidos que estão associados à mesa especificada
            if (pedido.getMesa() != null && pedido.getMesa().getTableNum() == mesa.getTableNum()) {
                total += pedido.getProductValue() * pedido.getProductQuantity();  
            }
        }
        return total;
    }
}