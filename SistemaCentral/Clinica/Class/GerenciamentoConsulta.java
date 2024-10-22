package Clinica.Class;

import java.text.SimpleDateFormat;
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
            System.out.println("Deseja cadastrar um novo paciente? (S/N)");
            String resposta = leitor.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                // Se o usuário confirmar, cadastrar o novo paciente
                paciente = GerenciamentoPaciente.cadastrarPaciente(leitor);
            } else {
                System.out.println("Consulta não agendada, paciente não encontrado.");
                return;
            }
        }

        System.out.println("Digite o nome do médico:");
        String nomeMedico = leitor.nextLine();
        Medico medico = GerenciamentoMedico.buscarMedico(nomeMedico);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            System.out.println("Deseja cadastrar um novo médico? (S/N)");
            String respostaMedico = leitor.nextLine();

            if (respostaMedico.equalsIgnoreCase("S")) {
                // Se o usuário confirmar, cadastrar o novo médico
                medico = GerenciamentoMedico.adicionarMedico(leitor);
            } else {
                System.out.println("Consulta não agendada, médico não encontrado.");
                return;
            }
        } else if (!medico.isDisponivel()) {
            System.out.println("Médico não disponível.");
            return;
        }

        // Captura da data e hora
        System.out.println("Digite a data e hora da consulta (dd/MM/yyyy HH:mm):");
        String dataHoraStr = leitor.nextLine();
        Date dataHora = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            dataHora = formato.parse(dataHoraStr);
        } catch (Exception e) {
            System.out.println("Formato de data inválido.");
            return;
        }

        // Criação e adição da consulta
        Consulta consulta = new Consulta(paciente, medico, dataHora);
        medico.setDisponivel(false);
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso.");
    }

    public static void cancelarConsulta(Scanner leitor) {
        System.out.println("Digite o nome do paciente para cancelar a consulta:");
        String nomePaciente = leitor.nextLine();
        Paciente paciente = GerenciamentoPaciente.buscarPaciente(nomePaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Digite o nome do médico:");
        String nomeMedico = leitor.nextLine();
        Medico medico = GerenciamentoMedico.buscarMedico(nomeMedico);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        // Remover consulta correspondente
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equals(paciente) && consulta.getMedico().equals(medico)) {
                consultas.remove(consulta);
                System.out.println("Consulta cancelada com sucesso.");
                medico.setDisponivel(true);
                return;
            }
        }

        System.out.println("Nenhuma consulta encontrada para o paciente e médico informados.");
    }

    public static void listarConsultasPorMedico(String nomeMedico) {
        Medico medico = GerenciamentoMedico.buscarMedico(nomeMedico);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.println("Consultas do médico " + medico.getNome() + ":");
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico)) {
                System.out.println(consulta);
            }
        }
    }
}
