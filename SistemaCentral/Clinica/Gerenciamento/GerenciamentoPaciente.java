package Clinica.Gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;
import Clinica.Class.Consulta;
import Clinica.Class.Paciente;

public class GerenciamentoPaciente {
    private static ArrayList<Paciente> pacientes = new ArrayList<>(); // Lista global de pacientes

    // Método para cadastrar pacientes
    public static Paciente cadastrarPaciente(Scanner leitor) {
        System.out.println("\n----------Cadastrar Paciente----------");
        System.out.print("Digite o nome do paciente: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpf = leitor.nextLine(); // Altere para nextLine() para capturar o CPF como uma string

        System.out.print("Digite o telefone do paciente: ");
        String telefone = leitor.nextLine();

        System.out.print("Digite o email do paciente: ");
        String email = leitor.nextLine(); // Agora o e-mail será corretamente solicitado

        // Verifica se o CPF já está cadastrado
        if (buscarPacientePorCpf(cpf) != null) {
            System.out.println("Erro: Já existe um paciente com este CPF cadastrado.");
            return null;
        }

        // Cria e adiciona o novo paciente à lista
        Paciente novoPaciente = new Paciente(nome, email, telefone, cpf);
        pacientes.add(novoPaciente);
        System.out.println("Paciente cadastrado com sucesso!");

        return novoPaciente;
    }

    // Método para buscar pacientes por nome
    public static Paciente buscarPaciente(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;  // Apenas retorna o paciente sem imprimir nada
            }
        }
        System.out.println("Paciente não encontrado.");
        return null;
    }


    // Método para buscar pacientes por CPF
    public static Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }


    // Listar todos os pacientes cadastrados
    public static void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        System.out.println("Lista de pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente); // Usa o método toString() da classe Paciente
        }
    }

        // Listar consultas de um paciente específico
    public static void listarConsultasDoPaciente(String nomePaciente) {
        Paciente paciente = buscarPaciente(nomePaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Exibir os detalhes do paciente
        System.out.println("Paciente encontrado");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("CPF: " + paciente.getCpf());
        System.out.println("Celular: " + paciente.getNumeroCelular());
        System.out.println("Email: " + paciente.getEmail());

        // Listar as consultas
        System.out.println("Consultas do paciente " + paciente.getNome() + ":");
        boolean encontrouConsulta = false;

        for (Consulta consulta : GerenciamentoClinica.getConsultas()) {
            if (consulta.getPaciente().equals(paciente)) {
                System.out.println("Médico: " + consulta.getMedico().getNome() +", Data/Hora: " + consulta.getDataHora());
                encontrouConsulta = true;
            }
        }

        if (!encontrouConsulta) {
            System.out.println("Nenhuma consulta encontrada para este paciente.");
        }
    }
}
