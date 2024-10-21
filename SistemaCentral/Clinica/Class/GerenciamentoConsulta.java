package Clinica.Class;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GerenciamentoConsulta {
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static void agendarConsulta(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = leitor.nextLine();
        Paciente paciente = GerenciamentoPaciente.buscarPaciente(nomePaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Digite o nome do médico:");
        String nomeMedico = leitor.nextLine();
        Medico medico = GerenciamentoMedico.buscarMedico(nomeMedico);

        if (medico == null || !medico.isDisponivel()) {
            System.out.println("Médico não disponível.");
            return;
        }

        System.out.println("Digite a data e hora da consulta (dd/MM/yyyy HH:mm):");
        // Lógica para pegar data e hora

        Date dataHora = new Date(); // Exemplo
        Consulta consulta = new Consulta(paciente, medico, dataHora);
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso.");
    }

    public static void cancelarConsulta(Scanner leitor) {
        // Lógica para cancelar a consulta
    }

    public static void listarConsultasPorMedico(String nomeMedico) {
        // Lógica para listar consultas
    }
}
