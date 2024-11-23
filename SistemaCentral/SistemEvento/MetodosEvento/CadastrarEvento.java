package SistemEvento.MetodosEvento;

import java.util.Scanner;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Local;

public class CadastrarEvento {
    public static Evento cadastrarEvento(Scanner scan, Local local) {
        System.out.println("\n----------Cadastro do Evento----------");
        System.out.print("Nome do Evento: ");
        String nomeevento = scan.nextLine();
        System.out.print("Capacidade Máxima do Evento: ");
        int capacidade = scan.nextInt();
        
        System.out.print("Valor (ingresso) Evento: ");
        float valoringre = scan.nextFloat();

        // Cadastro da Data
        System.out.print("Dia do Evento: ");
        int diaevento = scan.nextInt();
        System.out.print("Mês do Evento: ");
        int mesevento = scan.nextInt();
        System.out.print("Ano do Evento: ");
        int anoevento = scan.nextInt();
        scan.nextLine(); // Consumir a nova linha

        return new Evento(nomeevento, diaevento, mesevento, anoevento, capacidade, valoringre, local);
    }
}
