package SistemEvento.MetodosEvento;

import java.util.Scanner;

import SistemEvento.Classe.Participante;


public class InfoParticipantes {
    public static Participante coletarInformacoesParticipante(Scanner scan) {
        System.out.println("\n----------Registro de Participantes----------");
        System.out.print("Nome do Participante: ");
        String nomeParticipante = scan.nextLine();
        System.out.print("Email do Participante: ");
        String emailParticipante = scan.nextLine();
        System.out.print("Número de Celular do Participante: ");
        String numeroCelularParticipante = scan.nextLine();

        String tipoIngresso = "Comum";

        return new Participante(nomeParticipante, emailParticipante, numeroCelularParticipante,  tipoIngresso);
    }
}
