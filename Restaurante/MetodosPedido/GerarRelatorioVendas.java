package Projetos.Restaurante.MetodosPedido;

import Projetos.Restaurante.Estruturas.PedidoStruct;
import java.util.List;

public class GerarRelatorioVendas {

    public static void gerarRelatorio(List<PedidoStruct> pedidoList) {
        float totalVendas = 0;

        System.out.println("Relatório de Vendas:");
        for (PedidoStruct pedido : pedidoList) {
            totalVendas += pedido.getValor() * pedido.getQuantidade();  // Encapsulamento
            System.out.println(pedido);
        }

        System.out.println("Total de vendas: R$ " + totalVendas);
    }
}
