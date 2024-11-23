package Clinica.Metodos;

import java.util.Scanner;
import Clinica.Class.Paciente;


public class CadastroPaciente {
    public static Paciente cadastrarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nome = leitor.nextLine();
        System.out.println("Digite o CPF do paciente:");
        String cpf = leitor.nextLine();
        System.out.println("Digite o telefone do paciente:");
        String telefone = leitor.nextLine();

        Paciente novoPaciente = new Paciente(nome, cpf, telefone);
        System.out.println("Paciente cadastrado com sucesso.");
        return novoPaciente;
    }
}
