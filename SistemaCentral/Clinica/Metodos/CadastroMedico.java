package Clinica.Metodos;

import java.util.ArrayList;
import java.util.Scanner;

import Clinica.Class.Medico;

public class CadastroMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public static Medico cadastrarMedico(Scanner leitor) {
        System.out.println("Digite o nome do médico:");
        String nome = leitor.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = leitor.nextLine();
        System.out.println("Digite o CRM do médico:");
        String crm = leitor.nextLine();
        System.out.println("O médico está disponível? (S/N)");
        boolean disponivel = leitor.nextLine().equalsIgnoreCase("S");

        Medico novoMedico = new Medico(nome, especialidade, disponivel, crm);
        medicos.add(novoMedico);
        System.out.println("Médico adicionado com sucesso.");

        return novoMedico;
    }
}
