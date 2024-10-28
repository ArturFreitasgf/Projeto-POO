package Clinica.Class;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoPaciente {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static Paciente cadastrarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nome = leitor.nextLine();
        System.out.println("Digite o CPF do paciente:");
        String cpf = leitor.nextLine();
        System.out.println("Digite o telefone do paciente:");
        String telefone = leitor.nextLine();

        Paciente novoPaciente = new Paciente(nome, cpf, telefone);
        pacientes.add(novoPaciente);
        System.out.println("Paciente cadastrado com sucesso.");

        return novoPaciente;
    }

    public static Paciente buscarPaciente(String nome) {
        return pacientes.stream()
                .filter(paciente -> paciente.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Paciente não encontrado.");
                    return null;
                });
    }
}
