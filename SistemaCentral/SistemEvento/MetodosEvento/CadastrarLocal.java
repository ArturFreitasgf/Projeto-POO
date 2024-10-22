package SistemEvento.MetodosEvento;

import java.util.Scanner;

import SistemEvento.Classe.Local;

public class CadastrarLocal {
    public static Local cadastrarLocal(Scanner scan) {
        System.out.println("\n----------Cadastro do Local do Evento----------");
        System.out.print("Endereço do Local: ");
        String enderecoLocal = scan.nextLine();
        System.out.print("Cidade do Local: ");
        String cidadeLocal = scan.nextLine();
        System.out.print("Tipo do Local: ");
        String tipoLocal = scan.nextLine();
        return new Local(enderecoLocal, cidadeLocal, tipoLocal);
    }
}
