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
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                // Paciente encontrado, imprimir as informações
                System.out.println("Paciente cadastrado: " + paciente.getNome());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Telefone: " + paciente.getTelefone());
    
                // Aqui você deve chamar um método para listar as consultas do paciente, se houver
                listarConsultasDoPaciente(paciente);
    
                return paciente; // Retorna o paciente encontrado
            }
        }
        System.out.println("Paciente não encontrado.");
        return null;
    }

    private static void listarConsultasDoPaciente(Paciente paciente) {
        boolean temConsultas = false;
        System.out.println("Consultas marcadas:");
    
        for (Consulta consulta : GerenciamentoClinica.getConsultas()) { // Certifique-se de ter um método que retorne a lista de consultas
            if (consulta.getPaciente().equals(paciente)) {
                System.out.println("Médico: " + consulta.getMedico().getNome() +
                                   ", Data/Hora: " + consulta.getDataHora());
                temConsultas = true;
            }
        }
    
        if (!temConsultas) {
            System.out.println("Nenhuma consulta marcada.");
        }
    }
}
