package Restaurante.Estruturas;

import Restaurante.Classes.Mesa;

public class PedidoStruct {
    private String produto;
    private float valor;
    private int quantidade;
    private int Id;
    private Mesa mesa;

    public PedidoStruct(String productName, float productValue, int productQuantity, int IdPedido, Mesa mesa){
        this.produto = productName;
        this.valor = productValue;
        this.quantidade = productQuantity;
        this.Id = IdPedido;
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
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