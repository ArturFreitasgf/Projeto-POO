package Restaurante.MetodosPedido;

import java.util.List;

import Restaurante.Analises.PedidoFavorito;
import Restaurante.Estruturas.PedidoStruct;

public class ListarPedidos {
    public static void listarPedidos(List<PedidoStruct> pedidoList){
        for(PedidoStruct pedido : pedidoList){
            System.out.println(pedido);
        }

        PedidoFavorito.exibirPedidoFavorito(pedidoList);
    }
}