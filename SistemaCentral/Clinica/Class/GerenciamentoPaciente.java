package Clinica.Class;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoPaciente {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static void adicionarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nome = leitor.nextLine();
        System.out.println("Digite o CPF:");
        String cpf = leitor.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = leitor.nextLine();

        Paciente novoPaciente = new Paciente(nome, cpf, telefone);
        pacientes.add(novoPaciente);
        System.out.println("Paciente adicionado com sucesso.");
    }

    public static Paciente buscarPaciente(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
            }
        }
        return null;
    }

    public static void editarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente a ser editado:");
        String nome = leitor.nextLine();
        Paciente paciente = buscarPaciente(nome);
        if (paciente != null) {
            System.out.println("1. Editar nome");
            System.out.println("2. Editar telefone");
            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome:");
                    String novoNome = leitor.nextLine();
                    paciente.setNome(novoNome);
                    break;
                case 2:
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = leitor.nextLine();
                    paciente.setTelefone(novoTelefone);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Paciente atualizado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
