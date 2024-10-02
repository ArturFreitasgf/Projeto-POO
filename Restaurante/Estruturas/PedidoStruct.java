package Restaurante.Estruturas;

public class PedidoStruct {
        private String produto;
        private float valor;
        private int quantidade;
        private int Id;
    
        public PedidoStruct(String productName, float productValue, int productQuantity, int IdPedido){
            this.produto = productName;
            this.valor = productValue;
            this.quantidade = productQuantity;
            this.Id = IdPedido;
        }
    
        public String getProductName(){
            return produto;
        }

        public int getProductQuantity(){
            return quantidade;
        }

        public int getProductId(){
            return Id;
        }

        public float getProductValue(){
            return valor;
        }

        public void setProductName(String name){
            this.produto = name;
        }

        public void setProductValue(float value){
            this.valor = value;
        }

        public void setProductQuantity(int quantity){
            this.quantidade = quantity;
        }

        @Override
        public String toString(){
            return String.format("{ID %d} - Pedido de: %s, na quantidade de %d a %.1f cada", Id, produto, quantidade, valor);
    }
}
