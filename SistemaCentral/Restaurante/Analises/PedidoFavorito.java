package Restaurante.Analises;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import Restaurante.Estruturas.PedidoStruct;

public class PedidoFavorito {
    
    public static void exibirPedidoFavorito(List<PedidoStruct> pedidoList){
        if (pedidoList.isEmpty()) {
            System.out.println("Não há pedidos realizados.");
            return;
        }
        
        // Mapa para armazenar o número total de itens vendidos por pedido
        Map<String, Integer> contagemPedidos = new HashMap<>();
        
        // Contar quantas vezes cada pedido foi feito
        for (PedidoStruct pedido : pedidoList) {
            String nomePedido = pedido.getProductName();  // Obtém o nome do produto
            int quantidadePedido = pedido.getProductQuantity();  // Obtém a quantidade do pedido
            
            // Se o pedido já foi contado, adiciona a quantidade ao contador, senão inicializa com a quantidade
            contagemPedidos.put(nomePedido, contagemPedidos.getOrDefault(nomePedido, 0) + quantidadePedido);
        }
        
        // Encontrar o pedido com o maior número de ocorrências
        String pedidoFavorito = null;
        int maxOcorrencias = 0;
        
        for (Map.Entry<String, Integer> entry : contagemPedidos.entrySet()) {
            if (entry.getValue() > maxOcorrencias) {
                maxOcorrencias = entry.getValue();
                pedidoFavorito = entry.getKey();
            }
        }
        
        if (pedidoFavorito != null) {
            System.out.println("O pedido mais feito é: " + pedidoFavorito + " com " + maxOcorrencias + " itens vendidos.");
        } else {
            System.out.println("Não foi possível determinar o pedido favorito.");
        }
    }
}
