package Clinica.Gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;
import Clinica.Class.Consulta;
import Clinica.Class.Paciente;

public class GerenciamentoPaciente {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static Paciente cadastrarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nome = leitor.nextLine();
        System.out.println("Digite o email do paciente:");
        String email = leitor.nextLine();
        System.out.println("Digite o telefone do paciente:");
        String telefone = leitor.nextLine();
        System.out.println("Digite o CPF do paciente:");
        String cpf = leitor.nextLine();

        Paciente novoPaciente = new Paciente(nome, email, telefone, cpf);
        pacientes.add(novoPaciente);
        System.out.println("Paciente cadastrado com sucesso.");

        return novoPaciente;
    }

    public static Paciente buscarPaciente(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                paciente.exibirInformacoes();
                listarConsultasDoPaciente(paciente);
                return paciente;
            }
        }
        System.out.println("Paciente não encontrado.");
        return null;
    }

    private static void listarConsultasDoPaciente(Paciente paciente) {
        System.out.println("Consultas marcadas:");
        boolean encontrou = false;

        for (Consulta consulta : GerenciamentoClinica.getConsultas()) {
            if (consulta.getPaciente().equals(paciente)) {
                System.out.println("Médico: " + consulta.getMedico().getNome() +
                                   ", Data/Hora: " + consulta.getDataHora());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada.");
        }
    }
}
