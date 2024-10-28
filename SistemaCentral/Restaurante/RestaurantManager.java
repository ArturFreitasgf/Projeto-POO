package Restaurante;

import Restaurante.Classes.Pedido;

import java.util.Scanner;

public class RestaurantManager {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        Pedido start = new Pedido(leitor);
        start.menu();
    }
}
